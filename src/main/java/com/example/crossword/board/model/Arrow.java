package com.example.crossword.board.model;

import java.util.Random;

public enum Arrow {

    RIGHT_ON_MIDDLE,
    RIGHT_ON_TOP,
    RIGHT_ON_BOTTOM,

    DOWN_ON_MIDDLE,
    DOWN_ON_LEFT,
    DOWN_ON_RIGHT;

    private static final Random RANDOM = new Random();

    public boolean isHorizontal() {
        return this == RIGHT_ON_BOTTOM || this == RIGHT_ON_TOP || this == RIGHT_ON_MIDDLE;
    }

    public static Arrow randomDown() {
        Arrow[] values = {DOWN_ON_RIGHT, DOWN_ON_MIDDLE, DOWN_ON_LEFT};
        return values[RANDOM.nextInt(values.length)];
    }

    public static Arrow randomRight() {
        Arrow[] values = {RIGHT_ON_MIDDLE, RIGHT_ON_TOP, RIGHT_ON_BOTTOM};
        return values[RANDOM.nextInt(values.length)];
    }
}
