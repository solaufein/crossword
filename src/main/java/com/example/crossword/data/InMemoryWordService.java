package com.example.crossword.data;

import com.example.crossword.data.model.WordEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InMemoryWordService implements WordService {

    private final Map<Integer, List<WordEntity>> wordEntitiesPerLettersCount = new HashMap<>();

    @Override
    public void saveBatch(List<WordEntity> wordEntities) {
        Map<Integer, List<WordEntity>> grouped = wordEntities.stream()
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

    private List<WordEntity> join(List<WordEntity> a, List<WordEntity> b) {
        ArrayList<WordEntity> c = new ArrayList<>(a);
        c.addAll(b);
        return c;
    }

}
