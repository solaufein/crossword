package com.example.crossword.data;

import com.example.crossword.data.model.WordEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InMemoryWordService implements WordService {

    private final Map<Integer, List<WordEntity>> wordEntitiesPerLettersCount = new HashMap<>();

    @Override
    public void saveBatch(List<WordEntity> wordEntities) {
        AtomicLong idGenerator = new AtomicLong(1);
        Map<Integer, List<WordEntity>> grouped = wordEntities.stream()
                .peek(wordEntity -> assignWordId(idGenerator, wordEntity))
                .collect(Collectors.groupingBy(WordEntity::getTotalLetters));
        wordEntitiesPerLettersCount.putAll(grouped);
    }

    @Override
    public boolean isImportNeeded() {
        long count = size();
        log.info("total words in memory: {}", count);
        return count == 0;
    }

    @Override
    public long size() {
        return wordEntitiesPerLettersCount.values()
                .stream()
                .mapToLong(List::size)
                .sum();
    }

    @Override
    public Optional<WordEntity> findByWord(String word) {
        return wordEntitiesPerLettersCount.getOrDefault(word.length(), new ArrayList<>())
                .stream()
                .filter(wordEntity -> Objects.equals(wordEntity.getWord(), word))
                .findAny();
    }

    private void assignWordId(AtomicLong idGenerator, WordEntity wordEntity) {
        wordEntity.setId(idGenerator.getAndIncrement());
    }

}
