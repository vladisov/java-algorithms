package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingSubsequenceTest {

    @Test
    void test() {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        assertEquals(4, lis.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(4, lis.lengthOfLISLenBU(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(4, lis.lengthOfLISLenBUMy(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
