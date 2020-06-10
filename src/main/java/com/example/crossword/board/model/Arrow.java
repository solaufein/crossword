package com.example.crossword.board.model;

public enum Arrow {

    RIGHT_ON_MIDDLE,
    RIGHT_ON_TOP,
    RIGHT_ON_BOTTOM,

    DOWN_ON_MIDDLE,
    DOWN_ON_LEFT,
    DOWN_ON_RIGHT;

    public boolean isHorizontal() {
        return this == RIGHT_ON_BOTTOM || this == RIGHT_ON_TOP || this == RIGHT_ON_MIDDLE;
    }
}
