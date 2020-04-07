package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class LongestCommonSubsequenceTest {

    @Test
    void test() {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        assertThat(lcs.longestCommonSubsequence("abcde", "ace"), equalTo(3));
        assertThat(lcs.longestCommonSubsequenceBU("abcde", "ace"), equalTo(3));
        assertThat(lcs.longestCommonSubsequenceBUOptimized("abcde", "ace"), equalTo(3));
        assertThat(lcs.longestCommonSubsequence("ace", "ace"), equalTo(3));
        assertThat(lcs.longestCommonSubsequenceBU("ace", "ace"), equalTo(3));
        assertThat(lcs.longestCommonSubsequenceBUOptimized("ace", "ace"), equalTo(3));
        assertThat(lcs.longestCommonSubsequence("gxb", "ace"), equalTo(0));
        assertThat(lcs.longestCommonSubsequenceBU("gxb", "ace"), equalTo(0));
        assertThat(lcs.longestCommonSubsequenceBUOptimized("gxb", "ace"), equalTo(0));
    }
}
