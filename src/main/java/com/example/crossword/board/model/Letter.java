package com.example.crossword.board.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Letter extends Cell {

    public Letter(String value, int positionX, int positionY) {
        super(value, positionX, positionY);
    }

    @Override
    public boolean isQuestion() {
        return false;
    }

}
