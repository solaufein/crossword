package com.example.crossword.board.generator;

import com.example.crossword.board.model.Arrow;
import com.example.crossword.board.model.Board;
import com.example.crossword.board.model.Cell;
import com.example.crossword.board.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionGenerator {

    private static final Random RANDOM = new Random();

    public List<Question> generateOnTop(Board board) {
        List<Question> questions = new ArrayList<>();
        //todo: albo zrobic Cell.setReserved wszystkich pod Question i zwracac List<Cell> a przy losoaniu juz zamieniac Cell na Question ?
        //todo: albo zamienic Cell od razu na Question?

        Arrow arrow = null; //todo check arrow przy pobieraniu random next-a: hasFreeCellOnTop()
        while (board.hasFreeCellOnTop()) {
            Cell randomCell = board.getRandomCellOnTop();
            if (!randomCell.isReserved()) {
                arrow = Arrow.randomDown();
                Question question = new Question(randomCell.getPosition(), arrow);
                question.setReserved();
                board.putCell(question);
            }
        }

//        for (int i = 1; i <= board.getWidth(); i++) { //todo: tu idzie po kolei, wiec jest problem z Arrow on Left
//            Cell cell = board.getCell(Position.of(i, 1));
//            cell.setReserved();
//
//            arrow = Arrow.randomDown();
//            Question question = new Question(Position.of(i, 1), arrow);
//            questions.add(question);
//        }
        return questions;
    }

    public List<Question> generateOnLeft(Board board) {
        List<Question> questions = new ArrayList<>();
        int height = board.getHeight();

        return questions;
    }

    public List<Question> generateNext(Board board) {
        return new ArrayList<>();
    }

}
