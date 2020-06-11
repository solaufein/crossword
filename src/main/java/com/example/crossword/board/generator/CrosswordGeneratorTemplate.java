package com.example.crossword.board.generator;

import com.example.crossword.board.model.Answer;
import com.example.crossword.board.model.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CrosswordGeneratorTemplate {

    private final AnswerGenerator answerGenerator;

    public void createCrossword(String title, int height, int width) {
        Board board = new Board(title, width, height);

        while (board.hasFreeCellOnTop()) {
            Answer answer = answerGenerator.generateOnTop(board);
            boolean wasPlaced = tryPlaceOnBoard(answer, board);
            if (wasPlaced) {

            } else {

            }
        }

        while (board.hasFreeCellOnLeft()) {
            Answer answer = answerGenerator.generateOnLeft(board);
            boolean wasPlaced = tryPlaceOnBoard(answer, board);
            if (wasPlaced) {

            } else {

            }
        }

    }

    private boolean tryPlaceOnBoard(Answer answer, Board board) {
        if (board.canPlace(answer)) {
            board.place(answer);
            return true;
        }
        return false;
    }

}
