package com.example.crossword.board.generator;

import com.example.crossword.board.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionGenerator {

    private static final Random RANDOM = new Random();

    public List<Question> generateOnTop(Board board) {
        List<Question> questions = new ArrayList<>();
        //todo:

        while (board.hasFreeCellOnTop()) {

        }

        Arrow arrow = null;
        for (int i = 1; i <= board.getWidth(); i++) {
            Cell cell = board.getCell(Position.of(i, 1));
            cell.setTaken();

            arrow = Arrow.randomDown();
            Question question = new Question(Position.of(i, 1), arrow);
            questions.add(question);
        }
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
