package com.example.crossword.board.validator;

import com.example.crossword.board.model.*;
import com.example.crossword.board.utils.BoardUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class AnswerValidator {

    private AnswerValidator() {
    }

    public static void validate(Answer.AnswerBuilder answerBuilder) {
        validateHorizontalArrow(answerBuilder);
        validateVerticalArrow(answerBuilder);
        validateHorizontalLetters(answerBuilder);
        validateVerticalLetters(answerBuilder);
        validateStartingLettersPosition(answerBuilder);
        validateUniqueLettersPositions(answerBuilder);
    }

    private static void validateUniqueLettersPositions(Answer.AnswerBuilder answerBuilder) {
        Set<Position> uniquePositions = new HashSet<>();
        for (Letter letter : answerBuilder.getLetters()) {
            if (!uniquePositions.add(letter.getPosition())) {
                throw new IllegalArgumentException("Not unique letter position: " + letter.getPosition() + ", for question: " + answerBuilder.getQuestion());
            }
        }
    }

    private static void validateStartingLettersPosition(Answer.AnswerBuilder answerBuilder) {
        Position firstLetterPosition = BoardUtils.getFirstLetterPosition(answerBuilder.getLetters());
        Question question = answerBuilder.getQuestion();
        if (answerBuilder.getOrientation().isHorizontal()) {
            if (question.getArrow() == Arrow.RIGHT_ON_TOP) {
                if (firstLetterPosition.getPositionX() != question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() - 1 >= question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            } else if (question.getArrow() == Arrow.RIGHT_ON_MIDDLE) {
                if (firstLetterPosition.getPositionX() <= question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() != question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            } else if (question.getArrow() == Arrow.RIGHT_ON_BOTTOM) {
                if (firstLetterPosition.getPositionX() != question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() <= question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            }
        } else {
            if (question.getArrow() == Arrow.DOWN_ON_LEFT) {
                if (firstLetterPosition.getPositionX() - 1 >= question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() != question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            } else if (question.getArrow() == Arrow.DOWN_ON_MIDDLE) {
                if (firstLetterPosition.getPositionX() != question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() <= question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            } else if (question.getArrow() == Arrow.DOWN_ON_RIGHT) {
                if (firstLetterPosition.getPositionX() + 1 <= question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() != question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answerBuilder.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            }
        }
    }

    private static void validateHorizontalArrow(Answer.AnswerBuilder answerBuilder) {
        Question question = answerBuilder.getQuestion();
        if (answerBuilder.getOrientation().isHorizontal() && !question.getArrow().isHorizontal()) {
            throw new IllegalArgumentException("Invalid arrow: " + question.getArrow() + " for orientation: " + answerBuilder.getOrientation());
        }
    }

    private static void validateVerticalArrow(Answer.AnswerBuilder answerBuilder) {
        Question question = answerBuilder.getQuestion();
        if (!answerBuilder.getOrientation().isHorizontal() && question.getArrow().isHorizontal()) {
            throw new IllegalArgumentException("Invalid arrow: " + question.getArrow() + " for orientation: " + answerBuilder.getOrientation());
        }
    }

    private static void validateVerticalLetters(Answer.AnswerBuilder answerBuilder) {
        if (!answerBuilder.getOrientation().isHorizontal()) {
            List<Letter> letters = answerBuilder.getLetters();
            if (!letters.isEmpty()) {
                int firstYPosition = letters.get(0).getPosition().getPositionX();
                for (Letter letter : letters) {
                    if (letter.getPosition().getPositionX() != firstYPosition) {
                        throw new IllegalArgumentException("Invalid letter position: " + letter.getPosition() + " for orientation: " + answerBuilder.getOrientation());
                    }
                }
            }
        }
    }

    private static void validateHorizontalLetters(Answer.AnswerBuilder answerBuilder) {
        if (answerBuilder.getOrientation().isHorizontal()) {
            List<Letter> letters = answerBuilder.getLetters();
            if (!letters.isEmpty()) {
                int firstYPosition = letters.get(0).getPosition().getPositionY();
                for (Letter letter : letters) {
                    if (letter.getPosition().getPositionY() != firstYPosition) {
                        throw new IllegalArgumentException("Invalid letter position: " + letter.getPosition() + " for orientation: " + answerBuilder.getOrientation());
                    }
                }
            }
        }
    }
}
