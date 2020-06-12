package com.example.crossword.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrosswordServiceTest {

    @Autowired
    private CrosswordService crosswordService;

    @Test
    void create() {
        crosswordService.create();
    }
}