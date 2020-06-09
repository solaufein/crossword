package com.example.crossword.board.model;

import lombok.Data;

import java.util.List;

@Data
public class Board {
    private String title;
    private List<List<Cell>> cells;
    private List<Answer> answer;
    private int length;
    private int height;
}
