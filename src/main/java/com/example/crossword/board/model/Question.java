package com.example.crossword.board.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Question extends Cell {

    private final Arrow arrow;
    private long id;

    public Question(Position position, Arrow arrow) {
        super(position);
        this.arrow = arrow;
    }

    public Question(long id, String value, Position position, Arrow arrow) {
        super(position, value);
        this.arrow = arrow;
        this.id = id;
    }

    public void setId(long id) {
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
