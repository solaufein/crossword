package com.example.crossword.board;

import com.example.crossword.board.generator.AnswerGenerator;
import com.example.crossword.board.generator.CrosswordGenerator;
import com.example.crossword.board.generator.QuestionGenerator;
import com.example.crossword.board.model.Board;
import com.example.crossword.board.strategy.CrosswordStrategy;
import com.example.crossword.board.strategy.SimpleCrosswordStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CrosswordService {

    private final QuestionGenerator questionGenerator;
    private final AnswerGenerator answerGenerator;
    private final CrosswordGenerator crosswordGenerator;

    public void create() {
        CrosswordStrategy crosswordStrategy = new SimpleCrosswordStrategy(questionGenerator, answerGenerator);
        Board board = crosswordGenerator.generate("Sample crossword", 10, 5, crosswordStrategy);
        log.info("{}", board);
    }
}


