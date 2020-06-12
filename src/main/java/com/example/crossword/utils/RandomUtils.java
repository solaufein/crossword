package com.example.crossword.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    public static int getRandom(int min, int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }

}
