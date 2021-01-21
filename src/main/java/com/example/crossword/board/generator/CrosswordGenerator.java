package com.example.crossword.board.generator;

import com.example.crossword.board.model.Board;
import com.example.crossword.board.strategy.CrosswordStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CrosswordGenerator {

    public Board generate(String title, int width, int height, CrosswordStrategy crosswordStrategy) {
        Board board = new Board(title, width, height);
        log.info("initial board: {}", board);

        crosswordStrategy.generate(board);
        log.info("final board: {}", board);

        return board;
    }

}
