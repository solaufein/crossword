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
                .withQuestion(new Question("What?", new Position(1, 3), Arrow.DOWN_ON_MIDDLE, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", new Position(1, 4)),
                        new Letter("L", new Position(1, 5)),
                        new Letter("A", new Position(1, 6))))
                .build();

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), new Position(1, 4));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), new Position(1, 6));
    }

    @Test
    void getPositionsForVerticalAndArrowOnLeft() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question("What?", new Position(2, 3), Arrow.DOWN_ON_LEFT, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", new Position(1, 3)),
                        new Letter("L", new Position(1, 4)),
                        new Letter("A", new Position(1, 5))))
                .build();

        System.out.println(answer);

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), new Position(1, 3));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), new Position(1, 5));
    }

    @Test
    void getPositionsForVerticalAndArrowOnRight() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question("What?", new Position(2, 3), Arrow.DOWN_ON_RIGHT, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", new Position(3, 3)),
                        new Letter("L", new Position(3, 4)),
                        new Letter("A", new Position(3, 5))))
                .build();

        System.out.println(answer);

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), new Position(3, 3));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), new Position(3, 5));
    }

    @Test
    void getPositionsForHorizontal() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", new Position(3, 1), Arrow.RIGHT_ON_MIDDLE, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", new Position(4, 1)),
                        new Letter("L", new Position(5, 1)),
                        new Letter("A", new Position(6, 1))))
                .build();

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), new Position(4, 1));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), new Position(6, 1));
    }

    @Test
    void getPositionsForHorizontalAndArrowOnUpperRight() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", new Position(3, 2), Arrow.RIGHT_ON_TOP, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", new Position(3, 1)),
                        new Letter("L", new Position(4, 1)),
                        new Letter("A", new Position(5, 1))))
                .build();

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), new Position(3, 1));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), new Position(5, 1));
    }

    @Test
    void getPositionsForHorizontalAndArrowOnLowerRight() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", new Position(3, 2), Arrow.RIGHT_ON_BOTTOM, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", new Position(3, 3)),
                        new Letter("L", new Position(4, 3)),
                        new Letter("A", new Position(5, 3))))
                .build();

        assertEquals(BoardUtils.getFirstLetterPosition(answer.getLetters()), new Position(3, 3));
        assertEquals(BoardUtils.getLastLetterPosition(answer.getLetters()), new Position(5, 3));
    }

}