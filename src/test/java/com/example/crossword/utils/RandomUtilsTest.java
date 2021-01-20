package com.example.crossword.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomUtilsTest {

    @Test
    void getRandom() {
        int result = RandomUtils.getRandom(0, 5);
    }
}