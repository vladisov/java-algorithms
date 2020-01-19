package dev.algos.snatch.interview_problems.gss.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PermutationInStringTest {

    private PermutationInString solution = new PermutationInString();

    @Test
    void permutations() {
        assertTrue(solution.findPermutation("oidbcaf", "abc"));
        assertTrue(solution.findPermutation("bcdxabcdy", "bcdyabcdx"));
        assertTrue(solution.findPermutation("aaacb", "abc"));
        assertFalse(solution.findPermutation("odicf", "dc"));


        assertFalse(solution.findPermutation("ab", "a"));
        assertFalse(solution.findPermutation("a", "ab"));
        assertFalse(solution.findPermutation("horse", "ros"));

        assertTrue(solution.findPermutation("a", "a"));
        assertTrue(solution.findPermutation("ab", "eidbaooo"));
    }
}
