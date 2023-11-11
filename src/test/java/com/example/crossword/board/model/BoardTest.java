package com.example.crossword.board.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    @Test
    void testToString() {
        Question question1 = new Question(1L, "bla bla 1", Position.of(1, 4), Orientation.HORIZONTAL, Arrow.RIGHT_ON_MIDDLE);
        Question question2 = new Question(2L, "bla bla 2", Position.of(2, 4), Orientation.VERTICAL, Arrow.RIGHT_ON_TOP);
        Question question3 = new Question(3L, "bla bla 3", Position.of(3, 4), Orientation.HORIZONTAL, Arrow.DOWN_ON_MIDDLE);
        List<Letter> letters1 = asList(
                new Letter("A", Position.of(1, 1)),
                new Letter("L", Position.of(2, 1)),
                new Letter("A", Position.of(3, 1)));
        List<Letter> letters2 = asList(
                new Letter("K", Position.of(1, 2)),
                new Letter("O", Position.of(2, 2)),
                new Letter("T", Position.of(3, 2)));
        List<Letter> letters3 = asList(
                new Letter("M", Position.of(1, 3)),
                new Letter("A", Position.of(2, 3)),
                new Letter("A", Position.of(3, 3)));
        Answer answer1 = Answer.AnswerBuilder.anAnswer()
                .withQuestion(question1)
                .withLetters(letters1)
                .build();
        Answer answer2 = Answer.AnswerBuilder.anAnswer()
                .withQuestion(question2)
                .withLetters(letters2)
                .build();
        Answer answer3 = Answer.AnswerBuilder.anAnswer()
                .withQuestion(question3)
                .withLetters(letters3)
                .build();

        Board board = new Board("Some crossword", 3, 4);
        board.addAllAnswers(asList(answer1, answer2, answer3));
        board.putCells(createCells(question1, letters1));
        board.putCells(createCells(question2, letters2));
        board.putCells(createCells(question3, letters3));

        assertEquals(
                "Crossword \n" +
                        "title: Some crossword\n" +
                        "width: 3\n" +
                        "height: 4\n" +
                        "[  A  ][  L  ][  A  ]\n" +
                        "[  K  ][  O  ][  T  ]\n" +
                        "[  M  ][  A  ][  A  ]\n" +
                        "[ Q-1 ][ Q-2 ][ Q-3 ]" +
                        "\n" +
                        "\n" +
                        "Answers: \n" +
                        "[ Q-1 ] (HORIZONTAL) pos(1,4) - ALA (bla bla 1)\n" +
                        "[ Q-2 ] (VERTICAL) pos(2,4) - KOT (bla bla 2)\n" +
                        "[ Q-3 ] (HORIZONTAL) pos(3,4) - MAA (bla bla 3)", board.toString());
    }

    private List<Cell> createCells(Question question, List<Letter> letters) {
        ArrayList<Cell> cells = new ArrayList<>(letters);
        cells.add(question);
        return cells;
    }
}