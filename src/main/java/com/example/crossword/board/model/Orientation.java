package com.example.crossword.board.model;

public enum Orientation {

    HORIZONTAL, VERTICAL;

    public boolean isHorizontal() {
        return this == HORIZONTAL;
    }

}
