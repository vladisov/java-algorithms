package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeNumberOfWaysTest {

    @Test
    void test() {
        var coinChange = new CoinChangeNumberOfWays();
        assertEquals(5, coinChange.countChange(new int[]{1, 2, 3}, 5));
        assertEquals(5, coinChange.countChangeMemo(new int[]{1, 2, 3}, 5));
        assertEquals(5, coinChange.countChangeBU(new int[]{1, 2, 3}, 5));
        assertEquals(5, coinChange.countChangeBUOptimized(new int[]{1, 2, 3}, 5));
    }
}
