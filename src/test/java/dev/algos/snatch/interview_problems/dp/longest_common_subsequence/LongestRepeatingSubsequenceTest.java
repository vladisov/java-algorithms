package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class LongestRepeatingSubsequenceTest {

    @Test
    void test() {
        LongestRepeatingSubsequence lrs = new LongestRepeatingSubsequence();
        assertThat(lrs.longestRepeating("tomorrow"), equalTo(2));
        assertThat(lrs.longestRepeating("aabdbcec"), equalTo(3));
        assertThat(lrs.longestRepeating("fmff"), equalTo(2));
        assertThat(lrs.longestRepeatingBU("tomorrow"), equalTo(2));
        assertThat(lrs.longestRepeatingBU("aabdbcec"), equalTo(3));
        assertThat(lrs.longestRepeatingBU("fmff"), equalTo(2));
    }
}
