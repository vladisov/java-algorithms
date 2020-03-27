package dev.algos.snatch.interview_problems.dp;

import dev.algos.snatch.interview_problems.dp.knapsack.TargetSumTotalWays;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class TargetSumTotalWaysTest {

    @Test
    void test() {
        TargetSumTotalWays ts = new TargetSumTotalWays();
        assertThat(ts.findTargetSubsets(new int[]{1, 1, 2, 3}, 1), equalTo(1));
        assertThat(ts.findTargetSubsets(new int[]{1, 2, 7, 1}, 9), equalTo(2));
    }
}
