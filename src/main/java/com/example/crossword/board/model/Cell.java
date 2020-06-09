package com.example.crossword.board.model;

import lombok.Data;

@Data
public class Cell {

    private String value;
    private int positionX;
    private int positionY;
    private boolean question;

    public Cell() {
        this.question = false;
    }

    public Cell(String value, int positionX, int positionY) {
        this.value = value;
        this.positionX = positionX;
        this.positionY = positionY;
        this.question = false;
    }
}
