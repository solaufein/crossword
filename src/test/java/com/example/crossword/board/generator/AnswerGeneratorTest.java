package com.example.crossword.board.generator;

import com.example.crossword.board.model.*;
import com.example.crossword.data.WordService;
import com.example.crossword.data.model.WordEntity;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AnswerGeneratorTest {

    //todo: tests for other arrows

    @Test
    void shouldFindAnswerForVerticalDownOnMiddle() {
        WordService wordService = mock(WordService.class);
        when(wordService.findByLength(5)).thenReturn(Optional.of(new WordEntity(1L, "HOUSE", "Where do you live in?", "H", 5)));

        Answer answer = new AnswerGenerator(wordService).findAnswer(new Question(Position.of(4, 2), Orientation.VERTICAL, Arrow.DOWN_ON_MIDDLE), 5);

        assertThat(answer.getLetters()).containsExactly(
                new Letter("H", Position.of(4, 3)),
                new Letter("O", Position.of(4, 4)),
                new Letter("U", Position.of(4, 5)),
                new Letter("S", Position.of(4, 6)),
                new Letter("E", Position.of(4, 7)));
        assertThat(answer.getQuestion().getId()).isEqualTo(1L);
        assertThat(answer.getQuestion().getArrow()).isEqualTo(Arrow.DOWN_ON_MIDDLE);
        assertThat(answer.getQuestion().getOrientation()).isEqualTo(Orientation.VERTICAL);
        assertThat(answer.getQuestion().getValue()).isEqualTo("Where do you live in?");
    }

    @Test
    void shouldFindAnswerForHorizontal() {
        WordService wordService = mock(WordService.class);
        when(wordService.findByLength(5)).thenReturn(Optional.of(new WordEntity(1L, "HOUSE", "Where do you live in?", "H", 5)));

        Answer answer = new AnswerGenerator(wordService).findAnswer(new Question(Position.of(4, 2), Orientation.HORIZONTAL, Arrow.RIGHT_ON_MIDDLE), 5);

        assertThat(answer.getLetters()).containsExactly(
                new Letter("H", Position.of(5, 2)),
                new Letter("O", Position.of(6, 2)),
                new Letter("U", Position.of(7, 2)),
                new Letter("S", Position.of(8, 2)),
                new Letter("E", Position.of(9, 2)));
        assertThat(answer.getQuestion().getId()).isEqualTo(1L);
        assertThat(answer.getQuestion().getArrow()).isEqualTo(Arrow.RIGHT_ON_MIDDLE);
        assertThat(answer.getQuestion().getOrientation()).isEqualTo(Orientation.HORIZONTAL);
        assertThat(answer.getQuestion().getValue()).isEqualTo("Where do you live in?");
    }
}