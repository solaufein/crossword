package com.example.crossword.board.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Cell {

    private final Position position;
    private boolean free;
    private String value;

    Cell(Position position) {
        this.position = position;
        this.value = null;
        this.free = true;
    }

    Cell(Position position, String value) {
        this.position = position;
        this.value = value;
        this.free = false;
    }

    public boolean isQuestion() {
        return false;
    }

    public boolean isFree() {
        return this.free;
//        return value == null || value.isBlank();
    }

    public void setTaken() {
        this.free = false;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[  " + value + "  ]";
    }

}
