package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MaximumLengthRepeatingSubarrayTest {

    @Test
    void test() {
        MaximumLengthRepeatingSubarray mlrs = new MaximumLengthRepeatingSubarray();
        assertThat(mlrs.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}), equalTo(3));
        assertThat(mlrs.findLengthBU(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}), equalTo(3));
        assertThat(mlrs.findLengthBUOptimized(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}), equalTo(3));
        assertThat(mlrs.findLengthBUOptimizedOn(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}), equalTo(3));
    }
}
