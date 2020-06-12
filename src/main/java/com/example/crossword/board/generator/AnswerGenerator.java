package com.example.crossword.board.generator;

import com.example.crossword.board.model.Answer;
import com.example.crossword.board.model.Letter;
import com.example.crossword.board.model.Position;
import com.example.crossword.board.model.Question;
import com.example.crossword.data.WordService;
import com.example.crossword.data.model.WordEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class AnswerGenerator {

    private final WordService wordService;

    public AnswerGenerator(@Qualifier("inMemoryWordService") WordService wordService) {
        this.wordService = wordService;
    }

    public Answer findAnswer(Question question, int length) {
        WordEntity wordEntity = wordService.findByLength(length).orElseThrow();
        updateQuestion(question, wordEntity.getId(), wordEntity.getQuestion());
        List<Letter> letters = createLetters(wordEntity, question);

        return Answer.AnswerBuilder.anAnswer()
                .withQuestion(question)
                .withLetters(letters)
                .build();
    }

    private void updateQuestion(Question question, Long id, String question2) {
        question.setId(id);
        question.setValue(question2);
        question.setReserved();
    }

    private List<Letter> createLetters(WordEntity wordEntity, Question question) {
        List<Letter> letters = new ArrayList<>();
        char[] wordChars = wordEntity.getWord().toCharArray();
        for (int i = 0; i < wordChars.length; i++) {
            Position position = calculatePositionBasedOnQuestion(question, i);
            String value = String.valueOf(wordChars[i]);
            letters.add(new Letter(value, position));
        }
        return letters;
    }

    private Position calculatePositionBasedOnQuestion(Question question, int nextLetterIndex) {
        Position questionPosition = question.getPosition();
        switch (question.getArrow()) {
            case RIGHT_ON_MIDDLE:
                return Position.of(questionPosition.getPositionX() + nextLetterIndex + 1, questionPosition.getPositionY());
            case RIGHT_ON_TOP:
                return Position.of(questionPosition.getPositionX() + nextLetterIndex, questionPosition.getPositionY() - nextLetterIndex);
            case RIGHT_ON_BOTTOM:
                return Position.of(questionPosition.getPositionX() + nextLetterIndex, questionPosition.getPositionY() + nextLetterIndex);
            case DOWN_ON_MIDDLE:
                return Position.of(questionPosition.getPositionX(), questionPosition.getPositionY() + nextLetterIndex + 1);
            case DOWN_ON_LEFT:
                return Position.of(questionPosition.getPositionX() - nextLetterIndex, questionPosition.getPositionY() + nextLetterIndex);
            case DOWN_ON_RIGHT:
                return Position.of(questionPosition.getPositionX() + nextLetterIndex, questionPosition.getPositionY() + nextLetterIndex);
            default:
                throw new IllegalArgumentException("Not supported arrow type: " + question.getArrow());
        }
    }

}
