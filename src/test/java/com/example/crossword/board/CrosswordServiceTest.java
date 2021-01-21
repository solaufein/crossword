package com.example.crossword.board;

import com.example.crossword.board.model.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CrosswordServiceTest {

    @Autowired
    private CrosswordService crosswordService;

    @Test
    void create() {
        String title = "Simple crossword title";
        int width = 12;
        int height = 6;

        Board result = crosswordService.create(title, width, height);

        assertNotNull(result);
    }

}