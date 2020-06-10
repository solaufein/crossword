package com.example.crossword.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Cell {

    private String value;
    private int positionX;
    private int positionY;

    public abstract boolean isQuestion();

}
