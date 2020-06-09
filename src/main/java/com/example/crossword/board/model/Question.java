package com.example.crossword.board.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Question extends Cell {

    public Question() {
        super();
        setQuestion(true);
    }

    public Question(String value, int positionX, int positionY) {
        super(value, positionX, positionY);
        setQuestion(true);
    }
}
