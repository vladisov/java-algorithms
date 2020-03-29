package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class UnboundedKnapsackTest {

    @Test
    void test() {
        UnboundedKnapsack knapsack = new UnboundedKnapsack();
        assertThat(knapsack.solveKnapsack(new int[]{15, 20, 50}, new int[]{1, 2, 3}, 5), equalTo(80));
        assertThat(knapsack.solveKnapsackBottomUp(new int[]{15, 20, 50}, new int[]{1, 2, 3}, 5), equalTo(80));
    }
}
