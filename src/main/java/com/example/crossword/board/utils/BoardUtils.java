package com.example.crossword.board.utils;

import com.example.crossword.board.model.Answer;
import com.example.crossword.board.model.Cell;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public final class BoardUtils {
    private BoardUtils() {
    }

    public static int getFromPosition(Answer answer) {
        List<Cell> cells = answer.getCells();
        if (cells.size() > 1) {
            if (!answer.getOrientation().isHorizontal()) {
                return cells.get(0).getPositionX();
            } else {
                return cells.get(0).getPositionY();
            }
        } else {
            log.warn("cannot get 'from' position in Answer: {}", answer);
            return 0;
        }
    }

    public static int getToPosition(Answer answer) {
        List<Cell> cells = answer.getCells();
        if (cells.size() > 1) {
            if (!answer.getOrientation().isHorizontal()) {
                return cells.get(cells.size() - 1).getPositionX();
            } else {
                return cells.get(cells.size() - 1).getPositionY();
            }
        } else {
            log.warn("cannot get 'to' position in Answer: {}", answer);
            return 0;
        }
    }
}
