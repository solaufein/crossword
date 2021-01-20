package com.example.crossword.board.generator;

import com.example.crossword.board.model.*;
import com.example.crossword.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QuestionGenerator {

    //todo: refactor class

    public Question generateNext(Position position, Orientation orientation, Arrow arrow) {
        return new Question(position, orientation, arrow);
    }

    public Position getNextQuestionPosition(Answer mainAnswer, int positionY) {
        int mainAnswerPositionX = mainAnswer.getLetters().get(positionY - 2).getPosition().getPositionX();

        return getNextQuestionPosition(mainAnswerPositionX, positionY);
    }

    public Position getNextQuestionPosition(int mainAnswerPositionX, int positionY) {
        if (mainAnswerPositionX == 1) {
            return Position.of(1, 1);
        }

        int positionX = RandomUtils.getRandom(1, mainAnswerPositionX);
        Position pos = Position.of(positionX, positionY);
        log.info("next letter position: {}", pos);
        return pos;
    }

}
