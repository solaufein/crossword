package com.example.crossword.board.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public final class Position {

    private final int positionX;
    private final int positionY;

    private Position(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static Position of(int x, int y) {
        if (x == 0 || y == 0) {
            throw new IllegalArgumentException("Cannot set value: 0 in Position");
        }
        return new Position(x, y);
    }

    @Override
    public String toString() {
        return "pos(" + positionX + "," + positionY + ")";
    }
}
