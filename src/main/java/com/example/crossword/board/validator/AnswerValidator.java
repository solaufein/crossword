package com.example.crossword.board.validator;

import com.example.crossword.board.model.*;
import com.example.crossword.board.utils.BoardUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class AnswerValidator {

    private AnswerValidator() {
    }

    public static void validate(Answer answer) {
        validateHorizontalArrow(answer);
        validateVerticalArrow(answer);
        validateHorizontalLetters(answer);
        validateVerticalLetters(answer);
        validateStartingLettersPosition(answer);
        validateUniqueLettersPositions(answer);
    }

    private static void validateUniqueLettersPositions(Answer answer) {
        Set<Position> uniquePositions = new HashSet<>();
        for (Letter letter : answer.getLetters()) {
            if (!uniquePositions.add(letter.getPosition())) {
                throw new IllegalArgumentException("Not unique letter position: " + letter.getPosition() + ", for question: " + answer.getQuestion());
            }
        }
    }

    private static void validateStartingLettersPosition(Answer answer) {
        Position firstLetterPosition = BoardUtils.getFirstLetterPosition(answer.getLetters());
        Question question = answer.getQuestion();
        if (answer.getOrientation().isHorizontal()) {
            if (question.getArrow() == Arrow.RIGHT_ON_TOP) {
                if (firstLetterPosition.getPositionX() != question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() >= question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            } else if (question.getArrow() == Arrow.RIGHT_ON_MIDDLE) {
                if (firstLetterPosition.getPositionX() <= question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() != question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            } else if (question.getArrow() == Arrow.RIGHT_ON_BOTTOM) {
                if (firstLetterPosition.getPositionX() != question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() <= question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            }
        } else {
            if (question.getArrow() == Arrow.DOWN_ON_LEFT) {
                if (firstLetterPosition.getPositionX() >= question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() != question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            } else if (question.getArrow() == Arrow.DOWN_ON_MIDDLE) {
                if (firstLetterPosition.getPositionX() != question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() <= question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            } else if (question.getArrow() == Arrow.DOWN_ON_RIGHT) {
                if (firstLetterPosition.getPositionX() <= question.getPosition().getPositionX()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
                if (firstLetterPosition.getPositionY() != question.getPosition().getPositionY()) {
                    throw new IllegalArgumentException("Invalid first letter position: " + firstLetterPosition + " for orientation: " + answer.getOrientation() + ", and question position: " + question.getPosition() + ", and arrow: " + question.getArrow());
                }
            }
        }
    }

    private static void validateHorizontalArrow(Answer answer) {
        Question question = answer.getQuestion();
        if (answer.getOrientation().isHorizontal() && !question.getArrow().isHorizontal()) {
            throw new IllegalArgumentException("Invalid arrow: " + question.getArrow() + " for orientation: " + answer.getOrientation());
        }
    }

    private static void validateVerticalArrow(Answer answer) {
        Question question = answer.getQuestion();
        if (!answer.getOrientation().isHorizontal() && question.getArrow().isHorizontal()) {
            throw new IllegalArgumentException("Invalid arrow: " + question.getArrow() + " for orientation: " + answer.getOrientation());
        }
    }

    private static void validateVerticalLetters(Answer answer) {
        if (!answer.getOrientation().isHorizontal()) {
            List<Letter> letters = answer.getLetters();
            if (!letters.isEmpty()) {
                int firstYPosition = letters.get(0).getPosition().getPositionX();
                for (Letter letter : letters) {
                    if (letter.getPosition().getPositionX() != firstYPosition) {
                        throw new IllegalArgumentException("Invalid letter position: " + letter.getPosition() + " for orientation: " + answer.getOrientation());
                    }
                }
            }
        }
    }

    private static void validateHorizontalLetters(Answer answer) {
        if (answer.getOrientation().isHorizontal()) {
            List<Letter> letters = answer.getLetters();
            if (!letters.isEmpty()) {
                int firstYPosition = letters.get(0).getPosition().getPositionY();
                for (Letter letter : letters) {
                    if (letter.getPosition().getPositionY() != firstYPosition) {
                        throw new IllegalArgumentException("Invalid letter position: " + letter.getPosition() + " for orientation: " + answer.getOrientation());
                    }
                }
            }
        }
    }
}
