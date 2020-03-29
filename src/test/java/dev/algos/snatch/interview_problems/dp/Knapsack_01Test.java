package dev.algos.snatch.interview_problems.dp;

import dev.algos.snatch.interview_problems.dp.knapsack.Knapsack;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class Knapsack_01Test {

    @Test
    void test() {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};

        assertThat(ks.solveKnapsack(profits, weights, 7), equalTo(22));
        assertThat(ks.solveKnapsackDpBrutForce(profits, weights, 7), equalTo(22));
        assertThat(ks.solveKnapsackDp(profits, weights, 7), equalTo(22));
    }
}
