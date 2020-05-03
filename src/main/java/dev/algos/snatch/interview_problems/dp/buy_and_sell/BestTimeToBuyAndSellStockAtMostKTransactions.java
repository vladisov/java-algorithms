package dev.algos.snatch.interview_problems.dp.buy_and_sell;

import java.util.Arrays;

/**
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 * <p>
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 * Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 */
public class BestTimeToBuyAndSellStockAtMostKTransactions {

    /**
     * Time O(kn)
     * Space O(kn)
     */
    private int quickFind(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) return 0;
        int days = prices.length;
        if (k >= days / 2) {
            return quickFind(prices);
        }
        int[][] buy = new int[days][k];
        int[][] sell = new int[days][k];
        Arrays.fill(buy[0], -prices[0]);
        for (int i = 1; i < prices.length; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], -prices[i]);
            sell[i][0] = Math.max(sell[i - 1][0], buy[i - 1][0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j - 1] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j] + prices[i]);
            }
        }
        return sell[days - 1][k - 1];
    }

}
