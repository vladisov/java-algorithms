package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyStockTest {

    private BestTimeToBuyStock bestTimeToBuyStock = new BestTimeToBuyStock();

    @Test
    void maxProfit() {
        int result = bestTimeToBuyStock.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        assertEquals(5, result);
    }

    @Test
    void noProfit() {
        int result = bestTimeToBuyStock.maxProfit(new int[]{7, 6, 4, 3, 1});
        assertEquals(0, result);
    }

}
