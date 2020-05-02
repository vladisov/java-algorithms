package dev.algos.snatch.interview_problems.dp.buy_and_sell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyAndSellStocksWithFeeTest {

    @Test
    void test() {
        BuyAndSellStocksWithFee bsell = new BuyAndSellStocksWithFee();
        assertEquals(8, bsell.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
