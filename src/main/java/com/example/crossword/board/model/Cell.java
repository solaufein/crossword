package com.example.crossword.board.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public abstract class Cell {

    private final String value;
    private final Position position;

    public Cell(String value, Position position) {
        this.value = value;
        this.position = position;
    }

    public abstract boolean isQuestion();

    public boolean isFree() {
        return value == null || value.isBlank();
    }

    @Override
    public String toString() {
        return "[  " + value + "  ]";
    }
}
