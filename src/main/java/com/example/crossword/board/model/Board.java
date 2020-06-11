package com.example.crossword.board.model;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode
public class Board {

    private final List<Answer> answers = new ArrayList<>();
    private final List<List<Cell>> cells;
    private final String title;
    private final int width;
    private final int height;

    public Board(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.cells = createAvailableCells(height, width);
    }

    public void addCell(Cell cell) {
        List<Cell> row = this.cells.get(cell.getPosition().getPositionY() - 1);
        Cell set = row.set(cell.getPosition().getPositionX() - 1, cell);
        if (set == null) {
            throw new IllegalArgumentException("cannot add cell - previous element not found");
        } else {
            if (!set.isFree()) {
                throw new IllegalArgumentException("cannot add cell - trying to replace cell which was not free: " + set + ", " + set.getPosition());
            }
        }
    }

    public void addCells(List<Cell> cells) {
        cells.forEach(this::addCell);
    }

    public List<List<Cell>> getAllCells() {
        return new ArrayList<>(cells);
    }

    public Cell getCell(Position position) {
        return cells.get(position.getPositionY())
                .get(position.getPositionX());
    }

    public void addAnswer(Answer answerToAdd) {
        this.answers.add(answerToAdd);
    }

    public void addAllAnswers(Collection<? extends Answer> answersToAdd) {
        this.answers.addAll(answersToAdd);
    }

    public List<Answer> getAnswers() {
        return new ArrayList<>(answers);
    }

    public String getTitle() {
        return title;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private List<List<Cell>> createAvailableCells(int height, int width) {
        List<List<Cell>> cells = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            List<Cell> rowX = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                rowX.add(new Cell(Position.of(x, y)));
            }
            cells.add(rowX);
        }
        return cells;
    }

    @Override
    public String toString() {
        return "Crossword \n" +
                "title: " + title + "\n" +
                "width: " + width + "\n" +
                "height: " + height + "\n" +
                cells.stream().map(list -> listToString(list, "")).collect(Collectors.joining("\n")) + "\n\n" +
                "Answers: \n" + listToString(answers, "\n");
    }

    private String listToString(List<?> list, String separator) {
        return list.stream().map(Object::toString).collect(Collectors.joining(separator));
    }
}
