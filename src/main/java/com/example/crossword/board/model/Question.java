package com.example.crossword.board.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(callSuper = true)
public class Question extends Cell {

    private final Arrow arrow;
    private final Orientation orientation;
    private long id;

    public Question(Position position, Orientation orientation, Arrow arrow) {
        super(position);
        this.orientation = orientation;
        this.arrow = arrow;
    }

    public Question(long id, String value, Position position, Orientation orientation, Arrow arrow) {
        super(position, value);
        this.orientation = orientation;
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
