package dev.algos.snatch.interview_problems.hash_table;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfMatchingSubsequencesTest {

    @Test
    void test() {
        NumberOfMatchingSubsequences matchingSubsequences = new NumberOfMatchingSubsequences();
        assertEquals(3, matchingSubsequences.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
}
