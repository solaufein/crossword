package com.example.crossword.board.strategy;

import com.example.crossword.board.model.Board;

@FunctionalInterface
public interface CrosswordStrategy {

    void generate(Board board);
}
