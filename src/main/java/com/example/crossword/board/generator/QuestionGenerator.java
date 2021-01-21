package com.example.crossword.board.generator;

import com.example.crossword.board.model.Arrow;
import com.example.crossword.board.model.Orientation;
import com.example.crossword.board.model.Position;
import com.example.crossword.board.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QuestionGenerator {

    public Question generateNextVertical(Position position) {
        return generateNext(position, Orientation.VERTICAL, Arrow.DOWN_ON_MIDDLE);
    }

    public Question generateNextHorizontal(Position position) {
        return generateNext(position, Orientation.HORIZONTAL, Arrow.RIGHT_ON_MIDDLE);
    }

    public Question generateNext(Position position, Orientation horizontal, Arrow rightOnMiddle) {
        return new Question(position, horizontal, rightOnMiddle);
    }

}
