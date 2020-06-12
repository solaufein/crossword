package com.example.crossword.board.strategy;

import com.example.crossword.board.generator.AnswerGenerator;
import com.example.crossword.board.generator.QuestionGenerator;
import com.example.crossword.board.model.Answer;
import com.example.crossword.board.model.Board;
import com.example.crossword.board.model.Question;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PanoramicCrosswordStrategy implements CrosswordStrategy {

    private final QuestionGenerator questionGenerator;
    private final AnswerGenerator answerGenerator;

    @Override
    public void generate(Board board) {
        //todo:
        List<Question> questionsOnTop = questionGenerator.generateOnTop(board);
        for (Question question : questionsOnTop) {
            Answer answer = answerGenerator.findAnswer(question, board.getQuestionLength());
            boolean wasPlaced = tryPlaceOnBoard(answer, board);
            if (wasPlaced) {

            } else {

            }
        }

        List<Question> questionsOnLeft = questionGenerator.generateOnLeft(board);
        for (Question question : questionsOnLeft) {
            Answer answer = answerGenerator.findAnswer(question, board.getQuestionLength());
            boolean wasPlaced = tryPlaceOnBoard(answer, board);
            if (wasPlaced) {

            } else {

            }
        }
    }

    private int getQuestionLength() {
        return 0;
    }

    private boolean tryPlaceOnBoard(Answer answer, Board board) {
        if (board.canPlace(answer)) {
            board.place(answer);
            return true;
        }
        return false;
    }
}
