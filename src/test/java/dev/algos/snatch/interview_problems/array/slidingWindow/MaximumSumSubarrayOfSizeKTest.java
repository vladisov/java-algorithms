package dev.algos.snatch.interview_problems.array.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSumSubarrayOfSizeKTest {

    private MaximumSumSubarrayOfSizeK solution = new MaximumSumSubarrayOfSizeK();

    @Test
    void findMaxSumSubArray() {
        assertEquals(9, solution.findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}));
        assertEquals(7, solution.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
    }
}
