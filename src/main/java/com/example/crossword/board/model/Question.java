package com.example.crossword.board.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Question extends Cell {

    public Question(String value, Position position) {
        super(value, position);
    }

    @Override
    public boolean isQuestion() {
        return true;
    }

}
