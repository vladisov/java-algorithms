package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestBitonicSubsequenceTest {

    @Test
    void test() {
        LongestBitonicSubsequence lbs = new LongestBitonicSubsequence();
        assertEquals(7, lbs.longestBitonicSubsequence(new int[]{4, 2, 5, 9, 7, 6, 10, 3, 1}));
        assertEquals(7, lbs.longestBitonicSubsequenceBU(new int[]{4, 2, 5, 9, 7, 6, 10, 3, 1}));
    }
}
