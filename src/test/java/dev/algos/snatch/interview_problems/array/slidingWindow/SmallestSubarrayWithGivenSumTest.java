package dev.algos.snatch.interview_problems.array.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestSubarrayWithGivenSumTest {

    private SmallestSubarrayWithGivenSum solution = new SmallestSubarrayWithGivenSum();

    @Test
    void findMinSubArray() {
        assertEquals(1, solution.findMinSubArray(new int[]{2, 1, 5, 2, 8}, 7));
        assertEquals(2, solution.findMinSubArray(new int[]{2, 1, 5, 2, 3, 2}, 7));
        assertEquals(3, solution.findMinSubArray(new int[]{3, 4, 1, 1, 6}, 8));
    }
}
