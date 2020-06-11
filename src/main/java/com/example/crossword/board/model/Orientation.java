package com.example.crossword.board.model;

import java.util.Random;

public enum Orientation {

    HORIZONTAL, VERTICAL;

    public boolean isHorizontal() {
        return this == HORIZONTAL;
    }

    public static Orientation random() {
        Random random = new Random();
        Orientation[] values = values();
        return values[random.nextInt(values.length)];
    }
}
