package com.example.crossword.board.model;

import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class Board {
    String title;
    List<List<Cell>> cells;
    List<Answer> answers;
    int length;
    int height;

    @Override
    public String toString() {
        return "Crossword title: " + title + "\n" +
                "length: " + length + "\n" +
                "height: " + height + "\n" +
                cells.stream().map(list -> listToString(list, "")).collect(Collectors.joining("\n")) + "\n\n" +
                "Answers: \n" + listToString(answers, "\n");
    }

    private String listToString(List<?> list, String separator) {
        return list.stream().map(Object::toString).collect(Collectors.joining(separator));
    }
}
