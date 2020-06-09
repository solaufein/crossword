package com.example.crossword.data.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public final class QuestionParser {

    private QuestionParser() {
    }

    public static boolean hasQuestion(String description) {
        String question = getQuestion(description);
        return question != null && !question.isBlank();
    }

    public static String getQuestion(String description) {
        String question = StringUtils.substringBetween(description, "##D:", ".");
        return question == null ? null : question.trim();
    }
}
