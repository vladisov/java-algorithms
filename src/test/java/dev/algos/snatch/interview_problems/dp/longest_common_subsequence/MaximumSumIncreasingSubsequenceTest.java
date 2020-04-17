package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumSumIncreasingSubsequenceTest {

    @Test
    void test() {
        MaximumSumIncreasingSubsequence mlis = new MaximumSumIncreasingSubsequence();
        assertEquals(32, mlis.findMaxSumIS(new int[]{4, 1, 2, 6, 10, 1, 12}));
        assertEquals(25, mlis.findMaxSumIS(new int[]{-4, 10, 3, 7, 15}));
        assertEquals(82, mlis.findMaxSumIS(new int[]{1, 3, 8, 4, 14, 6, 14, 1, 9, 4, 13, 3, 11, 17, 29}));

        assertEquals(32, mlis.findMaxSumISBU(new int[]{4, 1, 2, 6, 10, 1, 12}));
        assertEquals(25, mlis.findMaxSumISBU(new int[]{-4, 10, 3, 7, 15}));
        assertEquals(82, mlis.findMaxSumISBU(new int[]{1, 3, 8, 4, 14, 6, 14, 1, 9, 4, 13, 3, 11, 17, 29}));
    }
}
