package com.example.crossword.board.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Cell {

    private final String value;
    private final Position position;

    public Cell(Position position) {
        this.value = " ";
        this.position = position;
    }

    public Cell(String value, Position position) {
        this.value = value;
        this.position = position;
    }

    public boolean isQuestion() {
        return false;
    }

    public boolean isFree() {
        return value == null || value.isBlank();
    }

    @Override
    public String toString() {
        return "[  " + value + "  ]";
    }
}
