package dev.algos.snatch.interview_problems.array.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringKDistinctTest {

    private LongestSubstringKDistinct solution = new LongestSubstringKDistinct();

    @Test
    void findLength() {
        assertEquals(2, solution.findLength("araaci", 1));
        assertEquals(4, solution.findLength("araaci", 2));
        assertEquals(5, solution.findLength("cbbebi", 3));
    }
}
