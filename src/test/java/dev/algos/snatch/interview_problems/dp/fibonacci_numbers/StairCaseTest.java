package dev.algos.snatch.interview_problems.dp.fibonacci_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class StairCaseTest {

    @Test
    void test() {
        StairCase stairs = new StairCase();

        assertEquals(4, stairs.countStairs(3));
        assertEquals(7, stairs.countStairs(4));

        assertEquals(4, stairs.countStairsDp(3));
        assertEquals(7, stairs.countStairsDp(4));

        assertEquals(4, stairs.countStairsDpOptimized(3));
        assertEquals(7, stairs.countStairsDpOptimized(4));
    }
}
