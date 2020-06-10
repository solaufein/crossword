package com.example.crossword.board.utils;

import com.example.crossword.board.model.Letter;
import com.example.crossword.board.model.Position;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public final class BoardUtils {
    private BoardUtils() {
    }

    public static Position getFirstLetterPosition(List<Letter> letters) {
        if (letters.size() > 1) {
            return letters.get(0).getPosition();
        } else {
            throw new IllegalArgumentException("cannot get first letter position");
        }
    }

    public static Position getLastLetterPosition(List<Letter> letters) {
        if (letters.size() > 1) {
            return letters.get(letters.size() - 1).getPosition();
        } else {
            throw new IllegalArgumentException("cannot get last letter position");
        }
    }
}
