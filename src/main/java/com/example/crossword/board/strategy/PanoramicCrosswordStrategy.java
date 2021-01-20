package com.example.crossword.board.strategy;

import com.example.crossword.board.generator.AnswerGenerator;
import com.example.crossword.board.generator.QuestionGenerator;
import com.example.crossword.board.model.Answer;
import com.example.crossword.board.model.Board;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PanoramicCrosswordStrategy implements CrosswordStrategy {

    private final QuestionGenerator questionGenerator;
    private final AnswerGenerator answerGenerator;

    @Override
    public void generate(Board board) {
        //todo: impl
    }

    private boolean tryPlaceOnBoard(Answer answer, Board board) {
        if (board.canPlaceAnswer(answer)) {
            board.placeAnswer(answer);
            return true;
        }
        return false;
    }
}
