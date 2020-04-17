package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubsequencePatternMatchingTest {

    @Test
    void test() {
        SubsequencePatternMatching spm = new SubsequencePatternMatching();
        assertEquals(4, spm.countPattern("tomorrow", "tor"));
        assertEquals(4, spm.countPatternBU("tomorrow", "tor"));
        assertEquals(2, spm.countPattern("baxmx", "ax"));
        assertEquals(2, spm.countPatternBU("baxmx", "ax"));
    }
}
