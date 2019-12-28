package dev.algos.snatch.interview_problems.array.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithSameLettersAfterReplacementTest {

    private LongestSubstringWithSameLettersAfterReplacement solution = new LongestSubstringWithSameLettersAfterReplacement();

    @Test
    void findLength() {
        assertEquals(3, solution.findLength("abccde", 1));
        assertEquals(4, solution.findLength("abbcb", 1));
        assertEquals(5, solution.findLength("aabccbb", 2));
    }
}
