package com.example.crossword.board.validator;

import com.example.crossword.board.model.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class AnswerValidatorTest {

    @Test
    void shouldThrowOnInvalidLetterPositionForVerticalAndDownOnRight() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question("What?", Position.of(2, 2), Arrow.DOWN_ON_RIGHT, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(2, 2)),
                        new Letter("L", Position.of(2, 3)),
                        new Letter("A", Position.of(2, 4))))
                .build();
        try {
            AnswerValidator.validate(answer);
            fail("Exception was expected");
        } catch (Exception ex) {
            assertEquals("Invalid first letter position: pos(2,2) for orientation: VERTICAL, and question position: pos(2,2), and arrow: DOWN_ON_RIGHT", ex.getMessage());
        }
    }

    @Test
    void shouldThrowOnInvalidLetterPositionForVerticalAndDownOnLeft() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question("What?", Position.of(2, 2), Arrow.DOWN_ON_LEFT, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(2, 2)),
                        new Letter("L", Position.of(2, 3)),
                        new Letter("A", Position.of(2, 4))))
                .build();
        try {
            AnswerValidator.validate(answer);
            fail("Exception was expected");
        } catch (Exception ex) {
            assertEquals("Invalid first letter position: pos(2,2) for orientation: VERTICAL, and question position: pos(2,2), and arrow: DOWN_ON_LEFT", ex.getMessage());
        }
    }

    @Test
    void shouldThrowOnInvalidLetterPositionForVerticalAndDownOnMiddle() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question("What?", Position.of(2, 2), Arrow.DOWN_ON_MIDDLE, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(2, 2)),
                        new Letter("L", Position.of(2, 3)),
                        new Letter("A", Position.of(2, 4))))
                .build();
        try {
            AnswerValidator.validate(answer);
            fail("Exception was expected");
        } catch (Exception ex) {
            assertEquals("Invalid first letter position: pos(2,2) for orientation: VERTICAL, and question position: pos(2,2), and arrow: DOWN_ON_MIDDLE", ex.getMessage());
        }
    }

    @Test
    void shouldThrowOnInvalidLetterPositionForHorizontalAndRightOnBottom() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", Position.of(1, 3), Arrow.RIGHT_ON_BOTTOM, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(1, 3)),
                        new Letter("L", Position.of(2, 3)),
                        new Letter("A", Position.of(3, 3))))
                .build();
        try {
            AnswerValidator.validate(answer);
            fail("Exception was expected");
        } catch (Exception ex) {
            assertEquals("Invalid first letter position: pos(1,3) for orientation: HORIZONTAL, and question position: pos(1,3), and arrow: RIGHT_ON_BOTTOM", ex.getMessage());
        }
    }

    @Test
    void shouldThrowOnInvalidLetterPositionForHorizontalAndRightOnTop() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", Position.of(1, 3), Arrow.RIGHT_ON_TOP, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(1, 3)),
                        new Letter("L", Position.of(2, 3)),
                        new Letter("A", Position.of(3, 3))))
                .build();
        try {
            AnswerValidator.validate(answer);
            fail("Exception was expected");
        } catch (Exception ex) {
            assertEquals("Invalid first letter position: pos(1,3) for orientation: HORIZONTAL, and question position: pos(1,3), and arrow: RIGHT_ON_TOP", ex.getMessage());
        }
    }

    @Test
    void shouldThrowOnInvalidLetterPositionForHorizontalAndRightOnMiddle() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", Position.of(1, 3), Arrow.RIGHT_ON_MIDDLE, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(1, 3)),
                        new Letter("L", Position.of(2, 3)),
                        new Letter("A", Position.of(3, 3))))
                .build();
        try {
            AnswerValidator.validate(answer);
            fail("Exception was expected");
        } catch (Exception ex) {
            assertEquals("Invalid first letter position: pos(1,3) for orientation: HORIZONTAL, and question position: pos(1,3), and arrow: RIGHT_ON_MIDDLE", ex.getMessage());
        }
    }

    @Test
    void shouldThrowWhenNotUniqueLettersPositions() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", Position.of(1, 3), Arrow.RIGHT_ON_MIDDLE, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(2, 3)),
                        new Letter("L", Position.of(2, 3)),
                        new Letter("A", Position.of(3, 3))))
                .build();
        try {
            AnswerValidator.validate(answer);
            fail("Exception was expected");
        } catch (Exception ex) {
            assertEquals("Not unique letter position: pos(2,3), for question: [ Q-1 ]", ex.getMessage());
        }
    }

    @Test
    void shouldThrowWhenNotVerticalLetters() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question("What?", Position.of(1, 3), Arrow.DOWN_ON_MIDDLE, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(1, 4)),
                        new Letter("L", Position.of(2, 5)),
                        new Letter("A", Position.of(3, 6))))
                .build();
        try {
            AnswerValidator.validate(answer);
            fail("Exception was expected");
        } catch (Exception ex) {
            assertEquals("Invalid letter position: pos(2,5) for orientation: VERTICAL", ex.getMessage());
        }
    }

    @Test
    void shouldThrowWhenNotHorizontalLetters() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", Position.of(1, 3), Arrow.RIGHT_ON_MIDDLE, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(1, 4)),
                        new Letter("L", Position.of(2, 5)),
                        new Letter("A", Position.of(3, 6))))
                .build();
        try {
            AnswerValidator.validate(answer);
            fail("Exception was expected");
        } catch (Exception ex) {
            assertEquals("Invalid letter position: pos(2,5) for orientation: HORIZONTAL", ex.getMessage());
        }
    }

    @Test
    void shouldThrowWhenOrientationHorizontalAndArrowNot() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withQuestion(new Question("What?", Position.of(1, 3), Arrow.DOWN_ON_MIDDLE, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(1, 4)),
                        new Letter("L", Position.of(1, 5)),
                        new Letter("A", Position.of(1, 6))))
                .build();
        try {
            AnswerValidator.validate(answer);
            fail("Exception was expected");
        } catch (Exception ex) {
            assertEquals("Invalid arrow: DOWN_ON_MIDDLE for orientation: HORIZONTAL", ex.getMessage());
        }
    }

    @Test
    void shouldThrowWhenOrientationVerticalAndArrowNot() {
        Answer answer = Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.VERTICAL)
                .withQuestion(new Question("What?", Position.of(1, 3), Arrow.RIGHT_ON_MIDDLE, 1L))
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(1, 4)),
                        new Letter("L", Position.of(1, 5)),
                        new Letter("A", Position.of(1, 6))))
                .build();
        try {
            AnswerValidator.validate(answer);
            fail("Exception was expected");
        } catch (Exception ex) {
            assertEquals("Invalid arrow: RIGHT_ON_MIDDLE for orientation: VERTICAL", ex.getMessage());
        }
    }

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