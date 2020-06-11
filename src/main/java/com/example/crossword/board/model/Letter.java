package com.example.crossword.board.model;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(callSuper = true)
@Value
public class Letter extends Cell {

    public Letter(String value, Position position) {
        super(position, value);
    }

    @Override
    public boolean isQuestion() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
