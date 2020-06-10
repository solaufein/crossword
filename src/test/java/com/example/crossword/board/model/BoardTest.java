package com.example.crossword.board.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    @Test
    void testToString() {
        Question question1 = new Question("bla bla 1", Position.of(2, 2), Arrow.RIGHT_ON_MIDDLE, 1L);
        Question question2 = new Question("bla bla 2", Position.of(5, 3), Arrow.RIGHT_ON_TOP, 2L);
        Question question3 = new Question("bla bla 3", Position.of(4, 7), Arrow.DOWN_ON_MIDDLE, 3L);
        List<Letter> letters1 = Arrays.asList(
                new Letter("A", Position.of(3, 4)),
                new Letter("L", Position.of(3, 4)),
                new Letter("A", Position.of(3, 4)));
        List<Letter> letters2 = Arrays.asList(
                new Letter("K", Position.of(3, 4)),
                new Letter("O", Position.of(3, 4)),
                new Letter("T", Position.of(3, 4)));
        List<Letter> letters3 = Arrays.asList(
                new Letter("M", Position.of(3, 4)),
                new Letter("A", Position.of(3, 4)),
                new Letter("M", Position.of(3, 4)),
                new Letter("A", Position.of(3, 4)));
        Answer answer1 = Answer.AnswerBuilder.anAnswer()
                .withQuestion(question1)
                .withOrientation(Orientation.HORIZONTAL)
                .withLetters(letters1)
                .build();
        Answer answer2 = Answer.AnswerBuilder.anAnswer()
                .withQuestion(question2)
                .withOrientation(Orientation.VERTICAL)
                .withLetters(letters2)
                .build();
        Answer answer3 = Answer.AnswerBuilder.anAnswer()
                .withQuestion(question3)
                .withOrientation(Orientation.HORIZONTAL)
                .withLetters(letters3)
                .build();

        Board board = new Board("Some crossword",
                Arrays.asList(
                        createCells(question1, letters1),
                        createCells(question2, letters2),
                        createCells(question3, letters3)),
                Arrays.asList(answer1, answer2, answer3), 3, 3);

        assertEquals(
                "Crossword title: Some crossword\n" +
                        "length: 3\n" +
                        "height: 3\n" +
                        "[  A  ][  L  ][  A  ][ Q-1 ]\n" +
                        "[  K  ][  O  ][  T  ][ Q-2 ]\n" +
                        "[  M  ][  A  ][  M  ][  A  ][ Q-3 ]" +
                        "\n" +
                        "\n" +
                        "Answers: \n" +
                        "[ Q-1 ] - ALA\n" +
                        "[ Q-2 ] - KOT\n" +
                        "[ Q-3 ] - MAMA", board.toString());
    }

    private List<Cell> createCells(Question question, List<Letter> letters) {
        ArrayList<Cell> cells = new ArrayList<>(letters);
        cells.add(question);
        return cells;
    }
}