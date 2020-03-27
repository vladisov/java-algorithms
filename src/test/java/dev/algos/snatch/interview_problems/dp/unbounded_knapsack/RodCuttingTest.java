package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class RodCuttingTest {

    @Test
    void test() {
        RodCutting rodCutting = new RodCutting();

        assertThat(rodCutting.solveRodCutting(new int[]{1, 2, 3, 4, 5}, new int[]{2, 6, 7, 10, 13}, 5), equalTo(14));
    }
}
