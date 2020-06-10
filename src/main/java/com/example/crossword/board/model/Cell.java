package com.example.crossword.board.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Cell {

    private String value;
    private Position position;

    public abstract boolean isQuestion();

    public boolean isFree() {
        return value == null || value.isBlank();
    }
}
