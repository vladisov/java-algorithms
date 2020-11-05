package dev.algos.snatch.interview_problems.dp.buy_and_sell;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockAtMostKTransactionsTest {

    @Test
    void test() {
        BestTimeToBuyAndSellStockAtMostKTransactions instance = new BestTimeToBuyAndSellStockAtMostKTransactions();
        assertEquals(2, instance.maxProfit(2, new int[]{2, 4, 1}));
        assertEquals(2, instance.maxProfitDP(2, new int[]{2, 4, 1}));
    }
}
