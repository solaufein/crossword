package com.example.crossword.board.model;

import lombok.Value;

import java.util.List;

@Value
public class Board {
    String title;
    List<List<Cell>> cells;
    List<Answer> answer;
    int length;
    int height;

    //todo: toString readable
}
