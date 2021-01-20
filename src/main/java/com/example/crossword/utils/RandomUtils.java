package com.example.crossword.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.OptionalInt;
import java.util.Random;

@Slf4j
public final class RandomUtils {

    private static final Random RANDOM = new Random();

    private RandomUtils() {
    }

    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    /**
     * @param min - inclusive
     * @param max - exclusive
     * @return random integer in given range
     */
    public static int getRandom(int min, int max) {
        log.debug("get random for range: {}-{}", min, max);
        OptionalInt first = RANDOM.ints(min, max).findFirst();
        return first.isPresent() ? first.getAsInt() : min;
    }

}
