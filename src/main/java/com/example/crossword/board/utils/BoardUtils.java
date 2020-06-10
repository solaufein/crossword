package com.example.crossword.board.utils;

import com.example.crossword.board.model.Answer;
import com.example.crossword.board.model.Letter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public final class BoardUtils {
    private BoardUtils() {
    }

    public static int getFromPosition(Answer answer) {
        List<Letter> letters = answer.getLetters();
        if (letters.size() > 1) {
            if (!answer.getOrientation().isHorizontal()) {
                return letters.get(0).getPosition().getPositionX();
            } else {
                return letters.get(0).getPosition().getPositionY();
            }
        } else {
            log.warn("cannot get 'from' position in Answer: {}", answer);
            return 0;
        }
    }

    public static int getToPosition(Answer answer) {
        List<Letter> letters = answer.getLetters();
        if (letters.size() > 1) {
            if (!answer.getOrientation().isHorizontal()) {
                return letters.get(letters.size() - 1).getPosition().getPositionX();
            } else {
                return letters.get(letters.size() - 1).getPosition().getPositionY();
            }
        } else {
            log.warn("cannot get 'to' position in Answer: {}", answer);
            return 0;
        }
    }
}
