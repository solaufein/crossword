package com.example.crossword.board.model;

import com.example.crossword.board.utils.BoardUtils;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode
@Getter
public class Answer {

    Question question;
    List<Letter> letters;

    private Answer(Question question, List<Letter> letters) {
        this.question = question;
        this.letters = letters;
    }

    public Position getFirstLetterPosition() {
        return BoardUtils.getFirstLetterPosition(this.getLetters());
    }

    public Position getLastLetterPosition() {
        return BoardUtils.getLastLetterPosition(this.getLetters());
    }

    public int getCount() {
        return letters.size();
    }

    public Position getQuestionPosition() {
        return getQuestion().getPosition();
    }

    @Getter
    public static final class AnswerBuilder {
        private Question question;
        private List<Letter> letters;

        private AnswerBuilder() {
        }

        public static AnswerBuilder anAnswer() {
            return new AnswerBuilder();
        }

        public AnswerBuilder withQuestion(Question question) {
            this.question = question;
            return this;
        }

        public AnswerBuilder withLetters(List<Letter> letters) {
            this.letters = letters;
            return this;
        }

        public Answer build() {
            return new Answer(question, letters);
        }

    }

    @Override
    public String toString() {
        return question + " (" + question.getOrientation() + ") - " + letters.stream().map(Letter::getValue).collect(Collectors.joining());
    }
}
