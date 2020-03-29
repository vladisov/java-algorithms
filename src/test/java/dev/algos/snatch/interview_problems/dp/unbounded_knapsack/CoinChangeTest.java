package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {

    @Test
    void test() {
        CoinChange coinChange = new CoinChange();
        assertEquals(3, coinChange.countChange(new int[]{1, 2, 5}, 11));
        assertEquals(-1, coinChange.countChange(new int[]{2}, 3));

        assertEquals(3, coinChange.countChangeBUOptimized(new int[]{1, 2, 5}, 11));
        assertEquals(-1, coinChange.countChangeBUOptimized(new int[]{2}, 3));
    }
}
