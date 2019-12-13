package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSubarrayTest {

    private MaximumSubarray solution = new MaximumSubarray();

    @Test
    void largestSum() {
        int result = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        assertEquals(6, result);
    }
}
