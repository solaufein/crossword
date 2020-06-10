package com.example.crossword.board.generator;

@FunctionalInterface
public interface Generator<T> {
    T generate();
}
