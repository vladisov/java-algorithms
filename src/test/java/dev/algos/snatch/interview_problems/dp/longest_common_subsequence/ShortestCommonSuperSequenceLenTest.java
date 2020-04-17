package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ShortestCommonSuperSequenceLenTest {

    @Test
    void test() {
        ShortestCommonSuperSequenceLen scsl = new ShortestCommonSuperSequenceLen();
        assertThat(scsl.findSCSLength("abcf", "bdcf"), equalTo(5));
        assertThat(scsl.findSCSLength("dynamic", "programming"), equalTo(15));
        assertThat(scsl.findSCSLengthBU("abcf", "bdcf"), equalTo(5));
        assertThat(scsl.findSCSLengthBU("dynamic", "programming"), equalTo(15));
    }
}
