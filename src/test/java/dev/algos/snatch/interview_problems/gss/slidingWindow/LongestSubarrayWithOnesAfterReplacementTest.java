package dev.algos.snatch.interview_problems.gss.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubarrayWithOnesAfterReplacementTest {

    private LongestSubarrayWithOnesAfterReplacement solution = new LongestSubarrayWithOnesAfterReplacement();

    @Test
    void findLength() {
        assertEquals(6, solution.findLength(new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1}, 2));
        assertEquals(9, solution.findLength(new int[]{0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1}, 3));
    }
}
