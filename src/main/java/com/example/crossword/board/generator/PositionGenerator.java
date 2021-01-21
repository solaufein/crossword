package com.example.crossword.board.generator;

import com.example.crossword.board.model.Position;
import com.example.crossword.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PositionGenerator {

    public Position generateTopHorizontalQuestionPosition(int width) {
        int x = RandomUtils.getRandom(2, width + 1);
        int y = 1;

        return Position.of(x, y);
    }

    public Position generateNextHorizontalQuestionPosition(int positionX, int positionY, int width) {
        if (positionX == 2) {
            return Position.of(1, positionY);
        }

        int randomPositionX = RandomUtils.getRandom(1, positionX + 1);
        if (randomPositionX + AnswerGenerator.MINIMUM_ANSWER_LENGTH > width) {
            return generateNextHorizontalQuestionPosition(positionX, positionY, width);
        } else {
            Position position = Position.of(randomPositionX, positionY);
            log.info("next question position: {}", position);
            return position;
        }
    }

}
