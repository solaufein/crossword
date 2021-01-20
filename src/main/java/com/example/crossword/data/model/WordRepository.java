package com.example.crossword.data.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WordRepository extends PagingAndSortingRepository<WordEntity, Long> {

    Optional<WordEntity> findByWord(String word);

    List<WordEntity> findAllByTotalLetters(int totalLetters);

}
