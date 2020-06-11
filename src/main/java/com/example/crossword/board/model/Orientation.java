package com.example.crossword.board.model;

import java.util.Random;

public enum Orientation {

    HORIZONTAL, VERTICAL;

    private static final Random RANDOM = new Random();

    public boolean isHorizontal() {
        return this == HORIZONTAL;
    }

    public static Orientation random() {
        Orientation[] values = values();
        return values[RANDOM.nextInt(values.length)];
    }
}
