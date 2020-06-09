package com.example.crossword.data;

import com.example.crossword.data.model.WordEntity;
import com.example.crossword.data.model.WordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Slf4j
@Service
public class WordService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private WordRepository wordRepository;

    @Value("${crossword.batch-size:100}")
    private int batchSize;

    @Transactional
    public void saveBatch(List<WordEntity> wordEntities) {
        for (int i = 0; i < wordEntities.size(); i++) {
            if (i > 0 && i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
            WordEntity wordEntity = wordEntities.get(i);
            entityManager.persist(wordEntity);
        }
    }

    public boolean isImportNeeded() {
        long count = wordRepository.count();
        log.info("total words in database: {}", count);
        return count == 0;
    }

}
