package com.example.crossword.board.generator;

import com.example.crossword.board.model.*;
import com.example.crossword.data.WordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;

@Slf4j
public class AnswerGenerator {

    private final WordService wordService;

    public AnswerGenerator(@Qualifier("inMemoryWordService") WordService wordService) {
        this.wordService = wordService;
    }

    public Answer generateOnTop(Board board) {
        return generateNext(board, Orientation.VERTICAL);
    }

    public Answer generateOnLeft(Board board) {
        return generateNext(board, Orientation.HORIZONTAL);
    }

    public Answer generateNext(Board board) {
        return generateNext(board, Orientation.random());
    }

    public Answer generateNext(Board board, Orientation orientation) {
        Question question = new Question("", Position.of(1, 1), Arrow.RIGHT_ON_MIDDLE, 1L);

        return Answer.AnswerBuilder.anAnswer()
                .withOrientation(orientation)
                .withLetters(new ArrayList<>())
                .withQuestion(question)
                .build();
    }

}
