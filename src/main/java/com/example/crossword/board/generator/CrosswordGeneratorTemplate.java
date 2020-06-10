package com.example.crossword.board.generator;

import com.example.crossword.board.model.Board;
import com.example.crossword.board.model.Question;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CrosswordGeneratorTemplate {

    private final Generator<Board> boardGenerator;
    private final Generator<Question> questionGenerator;

    public void createCrossword(String title, int height, int length) {
        int totalQuestions = calculateQuestions(height, length);

        Board board = boardGenerator.generate();

        for (int i = 0; i < totalQuestions; i++) {
            Question question = questionGenerator.generate();
            boolean isPlaced = tryPlaceOnBoard(question, board);
            if (isPlaced) {

            } else {

            }
        }

    }

    private boolean tryPlaceOnBoard(Question question, Board board) {
        return false;
    }

    private int calculateQuestions(int height, int length) {
        return 10;
    }
}
