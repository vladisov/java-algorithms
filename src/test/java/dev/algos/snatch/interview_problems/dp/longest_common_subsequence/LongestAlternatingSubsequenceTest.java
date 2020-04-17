package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestAlternatingSubsequenceTest {


    @Test
    void test() {
        LongestAlternatingSubsequence las = new LongestAlternatingSubsequence();
        assertEquals(2, las.longestAlternatingSubsequence(new int[]{1, 2, 3, 4}));
        assertEquals(3, las.longestAlternatingSubsequence(new int[]{3, 2, 1, 4}));
        assertEquals(4, las.longestAlternatingSubsequence(new int[]{1, 3, 2, 4}));
        assertEquals(2, las.longestAlternatingSubsequenceBU(new int[]{1, 2, 3, 4}));
        assertEquals(3, las.longestAlternatingSubsequenceBU(new int[]{3, 2, 1, 4}));
        assertEquals(4, las.longestAlternatingSubsequenceBU(new int[]{1, 3, 2, 4}));
    }
}
