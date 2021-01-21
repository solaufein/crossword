package com.example.crossword.board.generator;

import com.example.crossword.board.model.Answer;
import com.example.crossword.board.model.Letter;
import com.example.crossword.board.model.Position;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionGeneratorTest {

    @Test
    void getNextQuestionPositionOnBack() {
        Answer mainAnswer = Answer.AnswerBuilder.anAnswer()
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(5, 2)),
                        new Letter("B", Position.of(5, 3)),
                        new Letter("C", Position.of(5, 4))
                ))
                .build();

        QuestionGenerator questionGenerator = new QuestionGenerator();
        Position questionPosition = questionGenerator.getNextHorizontalQuestionPosition(mainAnswer, 2, 5);

        assertEquals(2, questionPosition.getPositionY());
        System.out.println("pos x: " + questionPosition.getPositionX());
        assertTrue(Arrays.asList(1).contains(questionPosition.getPositionX()));
    }

    @Test
    void getNextQuestionPositionOnFront() {
        Answer mainAnswer = Answer.AnswerBuilder.anAnswer()
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(2, 2)),
                        new Letter("B", Position.of(2, 3)),
                        new Letter("C", Position.of(2, 4))
                ))
                .build();

        QuestionGenerator questionGenerator = new QuestionGenerator();
        Position questionPosition = questionGenerator.getNextHorizontalQuestionPosition(mainAnswer, 2, 5);


        assertEquals(2, questionPosition.getPositionY());
        assertEquals(1, questionPosition.getPositionX());
    }

    @Test
    void getNextQuestionPositionOnMiddle() {
        Answer mainAnswer = Answer.AnswerBuilder.anAnswer()
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(3, 2)),
                        new Letter("B", Position.of(3, 3)),
                        new Letter("C", Position.of(3, 4))
                ))
                .build();

        QuestionGenerator questionGenerator = new QuestionGenerator();
        Position questionPosition = questionGenerator.getNextHorizontalQuestionPosition(mainAnswer, 2, 6);

        assertEquals(2, questionPosition.getPositionY());
        System.out.println("pos x: " + questionPosition.getPositionX());
        assertTrue(Arrays.asList(1, 2).contains(questionPosition.getPositionX()));
    }

    @Test
    void getNextQuestionPositionOnMiddle_2() {
        Answer mainAnswer = Answer.AnswerBuilder.anAnswer()
                .withLetters(Arrays.asList(
                        new Letter("A", Position.of(4, 2)),
                        new Letter("B", Position.of(4, 3)),
                        new Letter("C", Position.of(4, 4))
                ))
                .build();

        QuestionGenerator questionGenerator = new QuestionGenerator();
        Position questionPosition = questionGenerator.getNextHorizontalQuestionPosition(mainAnswer, 2, 7);

        assertEquals(2, questionPosition.getPositionY());
        System.out.println("pos x: " + questionPosition.getPositionX());
        assertTrue(Arrays.asList(1, 2, 3).contains(questionPosition.getPositionX()));
    }
}