package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author vladov 2019-12-08
 */
class BestTimeToBuyAndSellStockTest {

    private BestTimeToBuyAndSellStock instance;

    @BeforeEach
    void setUp() {
        instance = new BestTimeToBuyAndSellStock();
    }

    @Test
    void maxProfitHappyPath() {
        int result = instance.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assertThat(result, equalTo(5));
    }

    @Test
    void maxProfitNoTransactions() {
        int result = instance.maxProfit(new int[]{7, 6, 4, 3, 1});
        assertThat(result, equalTo(0));
    }

    @Test
    void maxProfitNegativeNoTransactions() {
        int result = instance.maxProfit(new int[]{-1, -2, -3, -4, -5});
        assertThat(result, equalTo(0));
    }

    @Test
    void maxProfitNegative() {
        int result = instance.maxProfit(new int[]{7, -1, 5, 3, 6, 4});
        assertThat(result, equalTo(7));
    }

    @Test
    void maxProfitEmptyArray() {
        int result = instance.maxProfit(new int[]{});
        assertThat(result, equalTo(0));
    }
}