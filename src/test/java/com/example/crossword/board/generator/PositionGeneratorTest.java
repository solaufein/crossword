package com.example.crossword.board.generator;

import com.example.crossword.board.model.Position;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PositionGeneratorTest {

    @Test
    void getNextQuestionPositionOnBack() {
        PositionGenerator generator = new PositionGenerator();
        Position questionPosition = generator.generateNextHorizontalQuestionPosition(5, 2, 5);

        assertEquals(2, questionPosition.getPositionY());
        System.out.println("pos x: " + questionPosition.getPositionX());
        assertTrue(Arrays.asList(1).contains(questionPosition.getPositionX()));
    }

    @Test
    void getNextQuestionPositionOnFront() {
        PositionGenerator generator = new PositionGenerator();
        Position questionPosition = generator.generateNextHorizontalQuestionPosition(2, 2, 5);


        assertEquals(2, questionPosition.getPositionY());
        assertEquals(1, questionPosition.getPositionX());
    }

    @Test
    void getNextQuestionPositionOnMiddle() {
        PositionGenerator generator = new PositionGenerator();
        Position questionPosition = generator.generateNextHorizontalQuestionPosition(3, 2, 6);

        assertEquals(2, questionPosition.getPositionY());
        System.out.println("pos x: " + questionPosition.getPositionX());
        assertTrue(Arrays.asList(1, 2).contains(questionPosition.getPositionX()));
    }

    @Test
    void getNextQuestionPositionOnMiddle_2() {
        PositionGenerator generator = new PositionGenerator();
        Position questionPosition = generator.generateNextHorizontalQuestionPosition(4, 2, 7);

        assertEquals(2, questionPosition.getPositionY());
        System.out.println("pos x: " + questionPosition.getPositionX());
        assertTrue(Arrays.asList(1, 2, 3).contains(questionPosition.getPositionX()));
    }

}