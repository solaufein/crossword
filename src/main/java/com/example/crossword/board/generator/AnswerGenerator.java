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
        return null;
    }

    public Answer generateOnLeft(Board board) {
        return null;
    }

    public Answer generateNext(Board board) {
        Question question = new Question("", Position.of(1, 1), Arrow.RIGHT_ON_MIDDLE, 1L);

        return Answer.AnswerBuilder.anAnswer()
                .withOrientation(Orientation.HORIZONTAL)
                .withLetters(new ArrayList<>())
                .withQuestion(question)
                .build();
    }

}
