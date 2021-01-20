package com.example.crossword.board.model;

import com.example.crossword.utils.RandomUtils;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
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
        this.cells = initAvailableCells(height, width);
    }

    public boolean canPlaceAnswer(Answer answer) {
        Orientation orientation = answer.getQuestion().getOrientation();

        if (answers.contains(answer)) {
            log.warn("board already contains this answer: {}", answer);
            return false;
        }

        //todo: validations
        switch (orientation) {
            case HORIZONTAL:
                if (answer.getLastLetterPosition().getPositionX() > width) {
                    log.warn("answer: {} last letter X position: {} is outside of board width: {}", answer, answer.getLastLetterPosition().getPositionX(), width);
                    return false;
                }
                break;
            case VERTICAL:
                if (answer.getLastLetterPosition().getPositionY() > height) {
                    log.warn("answer: {} last letter Y position: {} is outside of board height: {}", answer, answer.getLastLetterPosition().getPositionX(), width);
                    return false;
                }
                break;
        }

        return true;
    }

    public void placeAnswer(Answer answer) {
        putCell(answer.getQuestion());
        addAnswer(answer);
        putCells(answer.getLetters());
    }

    public boolean hasFreeCellOnTop() {
        for (Cell cell : this.cells.get(0)) {
            if (!cell.isReserved()) {
                return true;
            }
        }
        return false;
    }

    public Cell getRandomCellOnTop() {
        List<Cell> cellsOnTop = this.cells.get(0);
        int positionX = RandomUtils.getRandom(cellsOnTop.size());
        return cellsOnTop.get(positionX);
    }

    public boolean hasFreeCellOnLeft() {
        for (List<Cell> cell : this.cells) {
            if (!cell.get(0).isReserved()) {
                return true;
            }
        }
        return false;
    }

    public void putCell(Cell cell) {
        List<Cell> row = this.cells.get(cell.getPosition().getPositionY() - 1);
        Cell previousCell = row.set(cell.getPosition().getPositionX() - 1, cell);
        if (previousCell == null) {
            throw new IllegalArgumentException("cannot add cell - previous element not found");
        } else {
            if (!previousCell.isEmpty() && !Objects.equals(previousCell.getValue(), cell.getValue())) {
                throw new IllegalArgumentException("cannot add cell - trying to replace cell which was not free: " + previousCell + ", " + previousCell.getPosition());
            }
        }
    }

    public void putCells(List<? extends Cell> cells) {
        cells.forEach(this::putCell);
    }

    public Cell getCell(Position position) {
        return cells.get(position.getPositionY() - 1)
                .get(position.getPositionX() - 1);
    }

    public List<List<Cell>> getCells() {
        return new ArrayList<>(cells);
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

    private List<List<Cell>> initAvailableCells(int height, int width) {
        List<List<Cell>> cells = new ArrayList<>();
        for (int y = 1; y <= height; y++) {
            List<Cell> rowX = new ArrayList<>();
            for (int x = 1; x <= width; x++) {
                rowX.add(new Cell(Position.of(x, y)));
            }
            cells.add(rowX);
        }
        return cells;
    }

    private String listToString(List<?> list, String separator) {
        return list.stream().map(Object::toString).collect(Collectors.joining(separator));
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
}
