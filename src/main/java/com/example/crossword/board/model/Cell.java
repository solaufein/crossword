package com.example.crossword.board.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Cell {

    private final Position position;
    private boolean reserved;
    private String value;

    Cell(Position position) {
        this.position = position;
        this.value = null;
        this.reserved = false;
    }

    Cell(Position position, String value) {
        this.position = position;
        this.value = value;
        this.reserved = false;
    }

    public boolean isQuestion() {
        return false;
    }

    public boolean isReserved() {
        return this.reserved;
    }

    public boolean isEmpty() {
        return value == null || value.isBlank();
    }

    public void setReserved() {
        this.reserved = true;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPositionX() {
        return position.getPositionX();
    }

    public int getPositionY() {
        return position.getPositionY();
    }

    @Override
    public String toString() {
        return "[  " + value + "  ]";
    }

}
