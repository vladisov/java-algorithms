package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

import dev.algos.snatch.interview_problems.dp.longest_palindromic_substring.LongestPalindromicSubstring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicSubstringTest {

    @Test
    void test() {
        LongestPalindromicSubstring instance = new LongestPalindromicSubstring();
        assertEquals("bab", instance.longestPalindrome("babad"));
        instance = new LongestPalindromicSubstring();
        assertEquals("bb", instance.longestPalindrome("cbbd"));
        assertEquals("a", instance.longestPalindrome("a"));
    }
}
