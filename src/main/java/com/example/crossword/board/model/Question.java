package com.example.crossword.board.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Question extends Cell {

    private final Arrow arrow;
    private final long id;

    public Question(String value, Position position, Arrow arrow, long id) {
        super(value, position);
        this.arrow = arrow;
        this.id = id;
    }

    @Override
    public boolean isQuestion() {
        return true;
    }

    @Override
    public String toString() {
        return "[ Q-" + id + " ]";
    }
}
