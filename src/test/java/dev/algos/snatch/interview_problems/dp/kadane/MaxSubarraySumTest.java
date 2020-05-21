package dev.algos.snatch.interview_problems.dp.kadane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubarraySumTest {

    @Test
    void test() {
        MaxSubarraySum maxSubarraySum = new MaxSubarraySum();
        assertEquals(6, maxSubarraySum.maxSubArrayKadane(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(6, maxSubarraySum.maxSubArrayDp(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
