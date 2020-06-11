package com.example.crossword.board.utils;

import com.example.crossword.board.model.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardUtilsTest {

    @Test
    void getPositionsForVertical() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question(1L, "What?", Position.of(1, 3), Arrow.DOWN_ON_MIDDLE))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(1, 4)),
                        new Letter("L", Position.of(1, 5)),
                        new Letter("A", Position.of(1, 6))))
                .build();

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), Position.of(1, 4));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), Position.of(1, 6));
    }

    @Test
    void getPositionsForVerticalAndArrowOnLeft() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question(1L, "What?", Position.of(2, 3), Arrow.DOWN_ON_LEFT))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(1, 3)),
                        new Letter("L", Position.of(1, 4)),
                        new Letter("A", Position.of(1, 5))))
                .build();

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), Position.of(1, 3));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), Position.of(1, 5));
    }

    @Test
    void getPositionsForVerticalAndArrowOnRight() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question(1L, "What?", Position.of(2, 3), Arrow.DOWN_ON_RIGHT))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(3, 3)),
                        new Letter("L", Position.of(3, 4)),
                        new Letter("A", Position.of(3, 5))))
                .build();

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), Position.of(3, 3));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), Position.of(3, 5));
    }

    @Test
    void getPositionsForHorizontal() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question(1L, "What?", Position.of(3, 1), Arrow.RIGHT_ON_MIDDLE))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(4, 1)),
                        new Letter("L", Position.of(5, 1)),
                        new Letter("A", Position.of(6, 1))))
                .build();

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), Position.of(4, 1));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), Position.of(6, 1));
    }

    @Test
    void getPositionsForHorizontalAndArrowOnUpperRight() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question(1L, "What?", Position.of(3, 2), Arrow.RIGHT_ON_TOP))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(3, 1)),
                        new Letter("L", Position.of(4, 1)),
                        new Letter("A", Position.of(5, 1))))
                .build();

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), Position.of(3, 1));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), Position.of(5, 1));
    }

    @Test
    void getPositionsForHorizontalAndArrowOnLowerRight() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question(1L, "What?", Position.of(3, 2), Arrow.RIGHT_ON_BOTTOM))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(3, 3)),
                        new Letter("L", Position.of(4, 3)),
                        new Letter("A", Position.of(5, 3))))
                .build();

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), Position.of(3, 3));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), Position.of(5, 3));
    }

}