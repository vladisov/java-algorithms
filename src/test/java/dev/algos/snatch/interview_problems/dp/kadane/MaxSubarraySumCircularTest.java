package dev.algos.snatch.interview_problems.dp.kadane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubarraySumCircularTest {

    @Test
    void test() {
        MaxSubarraySumCircular instance = new MaxSubarraySumCircular();
        assertEquals(3, instance.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        assertEquals(10, instance.maxSubarraySumCircular(new int[]{5, -3, 5}));
        assertEquals(-1, instance.maxSubarraySumCircular(new int[]{-2, -3, -1}));

        assertEquals(3, instance.maxSubarraySumCircularOptimized(new int[]{1, -2, 3, -2}));
        assertEquals(10, instance.maxSubarraySumCircularOptimized(new int[]{5, -3, 5}));
        assertEquals(-1, instance.maxSubarraySumCircularOptimized(new int[]{-2, -3, -1}));
    }
}
