package com.example.crossword.board.utils;

import com.example.crossword.board.model.Answer;
import com.example.crossword.board.model.Letter;
import com.example.crossword.board.model.Orientation;
import com.example.crossword.board.model.Position;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardUtilsTest {

    @Test
    void getPositionsForHorizontal() {
        Answer answer = Answer.builder()
                .orientation(Orientation.HORIZONTAL)
                .letters(Arrays.asList(
                        new Letter("A", new Position(3, 1)),
                        new Letter("L", new Position(3, 2)),
                        new Letter("A", new Position(3, 3))))
                .build();

        assertEquals(BoardUtils.getFromPosition(answer), 1);
        assertEquals(BoardUtils.getToPosition(answer), 3);
    }

    @Test
    void getPositionsForVertical() {
        Answer answer = Answer.builder()
                .orientation(Orientation.VERTICAL)
                .letters(Arrays.asList(
                        new Letter("A", new Position(1, 3)),
                        new Letter("L", new Position(2, 3)),
                        new Letter("A", new Position(3, 3))))
                .build();

        assertEquals(BoardUtils.getFromPosition(answer), 1);
        assertEquals(BoardUtils.getToPosition(answer), 3);
    }

}