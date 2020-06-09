package com.example.crossword.board.model;

import com.example.crossword.board.utils.BoardUtils;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Answer {

    private Question question;
    private List<Cell> cells;
    private Orientation orientation;

    public int getFrom() {
        return BoardUtils.getFromPosition(this);
    }

    public int getTo() {
        return BoardUtils.getToPosition(this);
    }

    public int getCount() {
        return cells.size();
    }
}
