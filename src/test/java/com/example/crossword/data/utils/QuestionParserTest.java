package com.example.crossword.data.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuestionParserTest {

    @Test
    void hasQuestion() {
        assertTrue(QuestionParser.hasQuestion("##K: og. ##D: symbol stopni Celsjusza. [##P: Alarm we Włoszech – temperatura przekracza 40 stopni C.]"));
        assertTrue(QuestionParser.hasQuestion("##K: og. ##D: symbol stopni Celsjusza. bla bla. .."));
        assertFalse(QuestionParser.hasQuestion(""));
        assertFalse(QuestionParser.hasQuestion(" "));
        assertFalse(QuestionParser.hasQuestion(null));
    }
}