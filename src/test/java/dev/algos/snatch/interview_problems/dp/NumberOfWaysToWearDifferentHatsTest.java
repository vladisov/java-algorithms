package dev.algos.snatch.interview_problems.dp;

import dev.algos.snatch.interview_problems.dp.bitmask.NumberOfWaysToWearDifferentHats;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfWaysToWearDifferentHatsTest {

    @Test
    void test() {
        NumberOfWaysToWearDifferentHats instance = new NumberOfWaysToWearDifferentHats();
//        assertEquals(6, instance.numberWaysNaive(List.of(List.of(1, 2, 3), List.of(1, 2, 3), List.of(1, 2, 3))));
        assertEquals(4, instance.numberWays(List.of(List.of(3, 5, 1), List.of(3, 5))));
    }
}
