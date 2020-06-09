package com.example.crossword.data.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends PagingAndSortingRepository<WordEntity, Long> {

}
