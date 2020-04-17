package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortestCommonSupersequenceTest {


    @Test
    void test() {
        ShortestCommonSupersequence scs = new ShortestCommonSupersequence();

//        assertEquals("cabac", scs.shortestCommonSupersequence("abac", "cab"));
        assertEquals("babacdah", scs.shortestCommonSupersequence("abac", "babadah"));
    }
}
