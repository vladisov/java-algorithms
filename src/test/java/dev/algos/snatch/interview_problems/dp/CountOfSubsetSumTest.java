package dev.algos.snatch.interview_problems.dp;

import dev.algos.snatch.interview_problems.dp.knapsack.CountOfSubsetSum;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class CountOfSubsetSumTest {

    @Test
    void test() {
        CountOfSubsetSum instance = new CountOfSubsetSum();
        assertThat(instance.countSubsets(new int[]{1, 1, 2, 3}, 4), equalTo(3));
        assertThat(instance.countSubsets(new int[]{1, 2, 7, 1, 5}, 9), equalTo(3));

        assertThat(instance.countSubsetsMemo(new int[]{1, 1, 2, 3}, 4), equalTo(3));
        assertThat(instance.countSubsetsMemo(new int[]{1, 2, 7, 1, 5}, 9), equalTo(3));

        assertThat(instance.countSubsetsDP(new int[]{1, 1, 2, 3}, 4), equalTo(3));
        assertThat(instance.countSubsetsDP(new int[]{1, 2, 7, 1, 5}, 9), equalTo(3));

        assertThat(instance.countSubsetsDPOptimized(new int[]{1, 1, 2, 3}, 4), equalTo(3));
        assertThat(instance.countSubsetsDPOptimized(new int[]{1, 2, 7, 1, 5}, 9), equalTo(3));
    }
}
