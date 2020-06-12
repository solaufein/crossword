package com.example.crossword.board.strategy;

import com.example.crossword.board.generator.AnswerGenerator;
import com.example.crossword.board.generator.QuestionGenerator;
import com.example.crossword.board.model.*;
import com.example.crossword.utils.RandomUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SimpleCrosswordStrategy implements CrosswordStrategy {

    private final QuestionGenerator questionGenerator;
    private final AnswerGenerator answerGenerator;

    @Override
    public void generate(Board board) {
        int posX = RandomUtils.getRandom(1, board.getWidth());
        Question mainQuestion = questionGenerator.generateNext(Position.of(posX, 1), Orientation.VERTICAL, Arrow.DOWN_ON_MIDDLE);
        Answer answer = answerGenerator.findAnswer(mainQuestion, board.getHeight() - 1);
        board.putCell(mainQuestion);
        board.putCells(answer.getLetters());

        log.info("main question board: {}", board);

        //todo
        for (int i = 0; i < board.getHeight(); i++) {

        }

        int posY = 1;
        Position position = Position.of(1, posY);
        Question question = questionGenerator.generateNext(position, Orientation.HORIZONTAL, Arrow.RIGHT_ON_MIDDLE);
    }
}
