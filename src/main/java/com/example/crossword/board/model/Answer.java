package com.example.crossword.board.model;

import com.example.crossword.board.utils.BoardUtils;
import com.example.crossword.board.validator.AnswerValidator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode
@ToString
@Getter
public class Answer {

    Question question;
    List<Letter> letters;
    Orientation orientation;

    private Answer(Question question, List<Letter> letters, Orientation orientation) {
        this.question = question;
        this.letters = letters;
        this.orientation = orientation;
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
        private Orientation orientation;

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

        public AnswerBuilder withOrientation(Orientation orientation) {
            this.orientation = orientation;
            return this;
        }

        public Answer build() {
            AnswerValidator.validate(this);

            return new Answer(question, letters, orientation);
        }

    }
}
