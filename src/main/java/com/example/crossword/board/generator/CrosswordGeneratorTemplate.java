package com.example.crossword.board.generator;

import com.example.crossword.board.model.Board;
import com.example.crossword.board.model.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CrosswordGeneratorTemplate {

    private final QuestionGenerator questionGenerator;

    public void createCrossword(String title, int height, int width) {
        Board board = new Board(title, width, height);
        QuestionGenerator questionGenerator = new QuestionGenerator(board);

        while (questionGenerator.generateNextQuestion()) {

        }

        int totalQuestions = 1;
        for (int i = 0; i < totalQuestions; i++) {
            boolean wasPlaced = questionGenerator.generateNextQuestion();
            if (wasPlaced) {

            } else {

            }
        }

    }

    private boolean tryPlaceOnBoard(Question question, Board board) {
        return false;
    }

    private int calculateQuestions(int height, int width) {
        return 10;
    }
}
