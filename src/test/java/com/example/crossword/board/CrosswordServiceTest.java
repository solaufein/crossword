package com.example.crossword.board;

import com.example.crossword.board.model.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrosswordServiceTest {

    @Autowired
    private CrosswordService crosswordService;

    @Test
    void create() {
        Board result = crosswordService.create();

        System.out.println("result board: " + result);
    }
}