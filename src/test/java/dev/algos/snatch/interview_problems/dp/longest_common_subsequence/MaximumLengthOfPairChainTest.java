package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MaximumLengthOfPairChainTest {

    @Test
    void test() {
        MaximumLengthOfPairChain instance = new MaximumLengthOfPairChain();
        assertThat(instance.findLongestChainRecursive(new int[][]{{1, 2}, {2, 3}, {3, 4}}), equalTo(2));
        assertThat(instance.findLongestChainBU(new int[][]{{1, 2}, {2, 3}, {3, 4}}), equalTo(2));
    }
}
