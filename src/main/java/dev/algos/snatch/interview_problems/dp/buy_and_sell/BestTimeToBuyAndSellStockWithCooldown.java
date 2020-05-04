package dev.algos.snatch.interview_problems.dp.buy_and_sell;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * <p>
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(n)
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int days = prices.length;
        int[] buy = new int[days];
        int[] sell = new int[days];
        int[] rest = new int[days];
        buy[0] = -prices[0];
        for (int i = 1; i < days; i++) {
            rest[i] = Math.max(sell[i - 1], rest[i - 1]); //we either continue to rest or we take last sell because WE CAN
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]); // we can do nothing or we can take last rest value
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]); // or just buy[i - 1] + prices[i]
        }
        return sell[days - 1];
    }

    /**
     * Time O(N)
     * Space O(1)
     */
    public int maxProfitOptimized(int[] prices) {
        if (prices.length == 0) return 0;
        int days = prices.length;
        int b0 = -prices[0], b1 = b0;
        int r0, r1 = 0, s0, s1 = 0;
        for (int i = 1; i < days; i++) {
            r0 = Math.max(s1, r1);
            b0 = Math.max(b1, r1 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            r1 = r0;
            b1 = b0;
            s1 = s0;
        }
        return s1;
    }
}
