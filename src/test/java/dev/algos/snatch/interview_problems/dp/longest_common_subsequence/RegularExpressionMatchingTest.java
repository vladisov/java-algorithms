package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegularExpressionMatchingTest {

    @Test
    void test() {
        RegularExpressionMatching rexp = new RegularExpressionMatching();
        assertTrue(rexp.isMatch("aa", "a*"));
        assertTrue(rexp.isMatch("ab", ".*"));
        assertTrue(rexp.isMatch("aab", "c*a*b"));
        assertFalse(rexp.isMatch("aa", "a"));
        assertFalse(rexp.isMatch("mississippi", "mis*is*p*."));
    }

}
