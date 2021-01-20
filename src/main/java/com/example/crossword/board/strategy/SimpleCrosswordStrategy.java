package com.example.crossword.board.strategy;

import com.example.crossword.board.generator.AnswerGenerator;
import com.example.crossword.board.generator.QuestionGenerator;
import com.example.crossword.board.model.*;
import com.example.crossword.utils.RandomUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class SimpleCrosswordStrategy implements CrosswordStrategy {

    private static final int MINIMUM_ANSWER_LENGTH = 4;
    private final QuestionGenerator questionGenerator;
    private final AnswerGenerator answerGenerator;

    @Override
    public void generate(Board board) {
        Answer mainAnswer = generateMainAnswer(board);
        log.info(board.toString());

        for (int y = 2; y <= board.getHeight(); y++) {
            generateNextAnswer(board, mainAnswer, y);
        }
    }

    private Answer generateMainAnswer(Board board) {
        Position mainQuestionPosition = Position.of(RandomUtils.getRandom(1, board.getWidth()), 1);
        Question mainQuestion = questionGenerator.generateNext(mainQuestionPosition, Orientation.VERTICAL, Arrow.DOWN_ON_MIDDLE);
        Answer mainAnswer = answerGenerator.findAnswer(mainQuestion, board.getHeight() - 1).orElseThrow(() -> new IllegalArgumentException("Could not generate main question"));
        board.placeAnswer(mainAnswer);

        log.info("main question: {}", mainAnswer);
        log.info("main first letter position: {}", mainAnswer.getFirstLetterPosition());
        return mainAnswer;
    }

    private void generateNextAnswer(Board board, Answer mainAnswer, int positionY) {
        log.info("generate next answer on y: {}", positionY);
        int width = board.getWidth();
        Question mainQuestion = mainAnswer.getQuestion();

        Position nextQuestionPosition = questionGenerator.getNextQuestionPosition(mainAnswer, positionY);
        Question nextQuestion = questionGenerator.generateNext(nextQuestionPosition, Orientation.HORIZONTAL, Arrow.RIGHT_ON_MIDDLE);
        Optional<Answer> nextAnswerOptional = answerGenerator.findAnswer(nextQuestion, RandomUtils.getRandom(MINIMUM_ANSWER_LENGTH, width));
        if (nextAnswerOptional.isEmpty()) {
            generateNextAnswer(board, mainAnswer, positionY);
        } else {
            Answer nextAnswer = nextAnswerOptional.get();
            if (board.canPlaceAnswer(nextAnswer)) {
                Position mainAnswerLetterPosition = Position.of(mainQuestion.getPosition().getPositionX(), positionY);
                Letter mainAnswerLetter = mainAnswer.getLetterOnPosition(mainAnswerLetterPosition);
                Letter nextAnswerLetter = nextAnswer.getLetterOnPosition(mainAnswerLetterPosition);

                if (Objects.equals(nextAnswerLetter, mainAnswerLetter)) {
                    if (board.canPlaceAnswer(nextAnswer)) {
                        board.placeAnswer(nextAnswer);
                        log.info(board.toString());
                    } else {
                        generateNextAnswer(board, mainAnswer, positionY);
                    }
                } else {
                    log.info("next answer did not match main answer letter");
                    generateNextAnswer(board, mainAnswer, positionY);
                }
            } else {
                generateNextAnswer(board, mainAnswer, positionY);
            }
        }
    }

}
