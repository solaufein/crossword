package com.example.crossword.board.validator;

import com.example.crossword.board.model.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class AnswerValidatorTest {

    //todo more tests for checking exceptions

    @Test
    void getPositionsForVertical() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question("What?", Position.of(1, 3), Arrow.DOWN_ON_MIDDLE, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(1, 4)),
                        new Letter("L", Position.of(1, 5)),
                        new Letter("A", Position.of(1, 6))))
                .build();
        AnswerValidator.validate(answer);
    }

    @Test
    void getPositionsForVerticalAndArrowOnLeft() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question("What?", Position.of(2, 3), Arrow.DOWN_ON_LEFT, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(1, 3)),
                        new Letter("L", Position.of(1, 4)),
                        new Letter("A", Position.of(1, 5))))
                .build();
        AnswerValidator.validate(answer);
    }

    @Test
    void getPositionsForVerticalAndArrowOnRight() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question("What?", Position.of(2, 3), Arrow.DOWN_ON_RIGHT, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(3, 3)),
                        new Letter("L", Position.of(3, 4)),
                        new Letter("A", Position.of(3, 5))))
                .build();
        AnswerValidator.validate(answer);
    }

    @Test
    void getPositionsForHorizontal() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", Position.of(3, 1), Arrow.RIGHT_ON_MIDDLE, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(4, 1)),
                        new Letter("L", Position.of(5, 1)),
                        new Letter("A", Position.of(6, 1))))
                .build();
        AnswerValidator.validate(answer);
    }

    @Test
    void getPositionsForHorizontalAndArrowOnUpperRight() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", Position.of(3, 2), Arrow.RIGHT_ON_TOP, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(3, 1)),
                        new Letter("L", Position.of(4, 1)),
                        new Letter("A", Position.of(5, 1))))
                .build();
        AnswerValidator.validate(answer);
    }

    @Test
    void getPositionsForHorizontalAndArrowOnLowerRight() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", Position.of(3, 2), Arrow.RIGHT_ON_BOTTOM, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(3, 3)),
                        new Letter("L", Position.of(4, 3)),
                        new Letter("A", Position.of(5, 3))))
                .build();
        AnswerValidator.validate(answer);
    }
}