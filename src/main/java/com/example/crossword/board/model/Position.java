package com.example.crossword.board.model;

import lombok.Value;

@Value
public class Position {

    int positionX;
    int positionY;

    public static Position of(int x, int y) {
        return new Position(x, y);
    }

    @Override
    public String toString() {
        return "pos(" + positionX + "," + positionY + ")";
    }
}
