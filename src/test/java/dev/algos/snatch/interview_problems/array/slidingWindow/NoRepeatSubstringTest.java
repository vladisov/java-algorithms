package dev.algos.snatch.interview_problems.array.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NoRepeatSubstringTest {

    private NoRepeatSubstring solution = new NoRepeatSubstring();

    @Test
    void findLength() {
        assertEquals(3, solution.findLength("aabccbb"));
        assertEquals(3, solution.findLength("abccde"));
        assertEquals(2, solution.findLength("abbbb"));
    }
}
