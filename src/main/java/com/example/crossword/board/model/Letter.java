package com.example.crossword.board.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Letter extends Cell {

    public Letter(String value, Position position) {
        super(value, position);
    }

    @Override
    public boolean isQuestion() {
        return false;
    }

}
