package dev.algos.snatch.interview_problems.dp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfWaysToWearDifferentHatsTest {

    @Test
    void test() {
        NumberOfWaysToWearDifferentHats instance = new NumberOfWaysToWearDifferentHats();
        assertEquals(6, instance.numberWays(List.of(List.of(1, 2, 3), List.of(1, 2, 3), List.of(1, 2, 3))));
    }
}
