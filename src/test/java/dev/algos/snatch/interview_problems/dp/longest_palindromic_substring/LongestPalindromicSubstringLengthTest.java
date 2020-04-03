package dev.algos.snatch.interview_problems.dp.longest_palindromic_substring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicSubstringLengthTest {

    @Test
    void test() {
        LongestPalindromicSubstringLength lps = new LongestPalindromicSubstringLength();
        assertEquals(3, lps.findLPSLength("abdbca"));
        assertEquals(3, lps.findLPSLength("cddpd"));

        assertEquals(3, lps.findLPSLengthBU("abdbca"));
        assertEquals(3, lps.findLPSLengthBU("cddpd"));
    }
}
