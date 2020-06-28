package dev.algos.snatch.interview_problems.pattern_matching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestPalindromeTest {

    @Test
    void test() {
        ShortestPalindrome shortestPalindrome = new ShortestPalindrome();
        assertEquals("dcbabcd", shortestPalindrome.shortestPalindrome("abcd"));
        assertEquals("aaacecaaa", shortestPalindrome.shortestPalindrome("aacecaaa"));
    }
}
