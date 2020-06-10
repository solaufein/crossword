package com.example.crossword.board.model;

import lombok.Value;

@Value
public class Position {

    int positionX;
    int positionY;

    @Override
    public String toString() {
        return "pos(" + positionX + "," + positionY + ")";
    }
}
