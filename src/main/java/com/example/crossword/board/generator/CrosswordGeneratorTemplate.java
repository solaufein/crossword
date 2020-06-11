package com.example.crossword.board.generator;

import com.example.crossword.board.model.Answer;
import com.example.crossword.board.model.Board;
import com.example.crossword.board.model.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CrosswordGeneratorTemplate {

    private final QuestionGenerator questionGenerator;
    private final AnswerGenerator answerGenerator;

    public void createCrossword(String title, int height, int width) {
        Board board = new Board(title, width, height);

        //todo:
        List<Question> questionsOnTop = questionGenerator.generateOnTop(board);
        for (Question question : questionsOnTop) {
            Answer answer = answerGenerator.findAnswer(question);
            boolean wasPlaced = tryPlaceOnBoard(answer, board);
            if (wasPlaced) {

            } else {

            }
        }

        List<Question> questionsOnLeft = questionGenerator.generateOnLeft(board);
        for (Question question : questionsOnLeft) {
            Answer answer = answerGenerator.findAnswer(question);
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
