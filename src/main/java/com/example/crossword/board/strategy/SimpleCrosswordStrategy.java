package com.example.crossword.board.strategy;

import com.example.crossword.board.generator.AnswerGenerator;
import com.example.crossword.board.generator.PositionGenerator;
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
    private final PositionGenerator positionGenerator;

    @Override
    public void generate(Board board) {
        Answer mainAnswer = generateMainAnswer(board);
        log.info("main answer board: {}", board);

        for (int y = 2; y <= board.getHeight(); y++) {
            generateNextAnswer(board, mainAnswer, y);
        }
    }

    private Answer generateMainAnswer(Board board) {
        Position mainQuestionPosition = positionGenerator.generateTopHorizontalQuestionPosition(board.getWidth());
        Question mainQuestion = questionGenerator.generateNextVertical(mainQuestionPosition);
        Answer mainAnswer = answerGenerator.generateAnswer(mainQuestion, board.getHeight() - 1).orElseThrow(() -> new IllegalArgumentException("Could not generate main question"));
        board.placeAnswer(mainAnswer);

        log.info("main question/answer: {}", mainAnswer);
        log.info("main answer first letter position: {}", mainAnswer.getFirstLetterPosition());
        return mainAnswer;
    }

    private void generateNextAnswer(Board board, Answer mainAnswer, int positionY) {
        log.info("generate next answer on y: {}", positionY);

        Position nextQuestionPosition = positionGenerator.generateNextHorizontalQuestionPosition(mainAnswer.getFirstLetterPosition().getPositionX(), positionY, board.getWidth());
        Question nextQuestion = questionGenerator.generateNextHorizontal(nextQuestionPosition);
        int answerLength = calculateAnswerLength(nextQuestion, board.getWidth());

        answerGenerator.generateAnswer(nextQuestion, answerLength)
                .ifPresentOrElse(
                        nextAnswer -> tryPlaceAnswerOnBoard(nextAnswer, board, mainAnswer, positionY),
                        () -> generateNextAnswer(board, mainAnswer, positionY)
                );
    }

    private void tryPlaceAnswerOnBoard(Answer nextAnswer, Board board, Answer mainAnswer, int positionY) {
        if (board.canPlaceAnswer(nextAnswer)) {
            Position mainAnswerLetterPosition = Position.of(mainAnswer.getQuestion().getPositionX(), positionY);
            Letter mainAnswerLetter = mainAnswer.getLetterOnPosition(mainAnswerLetterPosition);
            Letter nextAnswerLetter = nextAnswer.getLetterOnPosition(mainAnswerLetterPosition);

            if (isSameLetter(mainAnswerLetter, nextAnswerLetter)) {
                board.placeAnswer(nextAnswer);
                log.info("next answer board: {}", board);
            } else {
                log.info("next answer letter: {} MISMATCH main answer letter: {} on position: {}", nextAnswerLetter, mainAnswerLetter, mainAnswerLetterPosition);
                log.debug("next answer: {}", nextAnswer);
                generateNextAnswer(board, mainAnswer, positionY);
            }
        } else {
            generateNextAnswer(board, mainAnswer, positionY);
        }
    }

    private int calculateAnswerLength(Question nextQuestion, int width) {
        int questionPositionX = nextQuestion.getPositionX();
        int randomLength = RandomUtils.getRandom(AnswerGenerator.MINIMUM_ANSWER_LENGTH, width);

        if (questionPositionX + randomLength > width) {
            return calculateAnswerLength(nextQuestion, width);
        } else {
            return randomLength;
        }
    }

    private boolean isSameLetter(Letter mainAnswerLetter, Letter nextAnswerLetter) {
        return nextAnswerLetter != null
                && mainAnswerLetter.getValue().equalsIgnoreCase(nextAnswerLetter.getValue());
    }

}
