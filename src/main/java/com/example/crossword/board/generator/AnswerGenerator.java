package com.example.crossword.board.generator;

import com.example.crossword.board.model.Answer;
import com.example.crossword.board.model.Letter;
import com.example.crossword.board.model.Orientation;
import com.example.crossword.board.model.Question;
import com.example.crossword.data.WordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AnswerGenerator {

    private final WordService wordService;

    public AnswerGenerator(@Qualifier("inMemoryWordService") WordService wordService) {
        this.wordService = wordService;
    }

    public Answer findAnswer(Question question) {
        return findAnswer(question, Orientation.random());
    }

    private Answer findAnswer(Question question, Orientation orientation) {
        //todo: word.findWordForQuestion(question);
        //todo: and check if other words are fine
        long id = 1L;
        String value = "";
        List<Letter> letters = new ArrayList<>();

        question.setId(id);
        question.setValue(value);
        question.setReserved();

        return Answer.AnswerBuilder.anAnswer()
                .withOrientation(orientation)
                .withLetters(letters)
                .withQuestion(question)
                .build();
    }

}
