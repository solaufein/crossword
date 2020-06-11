package com.example.crossword.board.generator;

import com.example.crossword.board.model.Arrow;
import com.example.crossword.board.model.Board;
import com.example.crossword.board.model.Position;
import com.example.crossword.board.model.Question;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuestionGenerator {

    private final Board board;
    private final int totalQuestions;

    public QuestionGenerator(Board board) {
        this.board = board;
        this.totalQuestions = calculateTotalQuestions(board.getHeight(), board.getWidth());
    }

    public boolean generateNextQuestion() {
        Question question = new Question("", Position.of(1, 1), Arrow.RIGHT_ON_MIDDLE, 1L);
        return tryPlaceOnBoard(question, board);
    }

    private boolean tryPlaceOnBoard(Question question, Board board) {
        return true;
    }

    private int calculateTotalQuestions(int height, int width) {
        return height * width;
    }

}
