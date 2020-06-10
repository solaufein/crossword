package com.example.crossword.data;

import com.example.crossword.data.model.WordEntity;

import java.util.List;
import java.util.Optional;

public interface WordService {

    void saveBatch(List<WordEntity> wordEntities);

    boolean isImportNeeded();

    long size();

    Optional<WordEntity> findByWord(String word);
}
