package dev.algos.snatch.interview_problems.dp.fibonacci_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberFactorsTest {

    @Test
    void test() {
        NumberFactors instance = new NumberFactors();
        assertEquals(4, instance.countWaysDpOptimized(4));
        assertEquals(6, instance.countWaysDpOptimized(5));
        assertEquals(9, instance.countWaysDpOptimized(6));
    }
}
