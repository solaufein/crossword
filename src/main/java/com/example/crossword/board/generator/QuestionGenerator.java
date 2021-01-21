package com.example.crossword.board.generator;

import com.example.crossword.board.model.*;
import com.example.crossword.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QuestionGenerator {

    public Question generateNextVertical(Position position) {
        return new Question(position, Orientation.VERTICAL, Arrow.DOWN_ON_MIDDLE);
    }

    public Question generateNextHorizontal(Position position) {
        return new Question(position, Orientation.HORIZONTAL, Arrow.RIGHT_ON_MIDDLE);
    }

    public Position getNextHorizontalQuestionPosition(Answer mainAnswer, int positionY, int width) {
        int mainAnswerPositionX = mainAnswer.getFirstLetterPosition().getPositionX();

        if (mainAnswerPositionX == 2) {
            return Position.of(1, positionY);
        }

        int positionX = RandomUtils.getRandom(1, mainAnswerPositionX + 1);
        if (positionX + AnswerGenerator.MINIMUM_ANSWER_LENGTH > width) {
            return getNextHorizontalQuestionPosition(mainAnswer, positionY, width);
        } else {
            Position pos = Position.of(positionX, positionY);
            log.info("next question position: {}", pos);
            return pos;
        }
    }

}
