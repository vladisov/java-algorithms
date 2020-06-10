package dev.algos.snatch.interview_problems.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestSubarrayWithSumAtLeastKTest {

    @Test
    void test() {
        ShortestSubarrayWithSumAtLeastK instance = new ShortestSubarrayWithSumAtLeastK();
        assertEquals(1, instance.shortestSubarray(new int[]{77, 19, 35, 10, -14}, 19));
    }
}
