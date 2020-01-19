package dev.algos.snatch.interview_problems.gss.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestWindowContainingSubstringTest {

    private SmallestWindowContainingSubstring solution = new SmallestWindowContainingSubstring();

    @Test
    void findSubstring() {
        assertEquals("abdec", solution.findSubstring("aabdec", "abc"));
        assertEquals("abc", solution.findSubstring("abdabca", "abc"));
        assertEquals("", solution.findSubstring("adcad", "abc"));
    }
}
