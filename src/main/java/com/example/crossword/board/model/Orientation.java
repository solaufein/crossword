package com.example.crossword.board.model;

import com.example.crossword.utils.RandomUtils;

public enum Orientation {

    HORIZONTAL, VERTICAL;

    public boolean isHorizontal() {
        return this == HORIZONTAL;
    }

    public static Orientation random() {
        Orientation[] values = values();
        return values[RandomUtils.getRandom(values.length)];
    }
}
