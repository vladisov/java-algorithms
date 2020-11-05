package dev.algos.snatch.interview_problems.dp.buy_and_sell;

/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeBuyAndSellMultipleTransactions {

    /**
     * Easy peasy
     * TC O(N)
     * SC O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int profit = 0, currBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > currBuy) {
                profit += prices[i] - currBuy;
            }
            currBuy = prices[i];
        }
        return profit;
    }

    /**
     * Dynamic
     * TC O(N)
     * SC O(N)
     */
    public int maxProfitDP(int[] prices) {
        if (prices.length == 0) return 0;
        int days = prices.length;
        int[] buy = new int[days];
        int[] sell = new int[days];
        buy[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[days - 1];
    }

    public int maxProfitDP_V2(int[] prices) {
        if (prices.length == 0) return 0;
        int days = prices.length;
        int[][] dp = new int[days][2];

        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); //if we don't hold (sold prev day)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // if we hold
        }
        return dp[days - 1][0];
    }

    public int maxProfitDP_V2_Optimized(int[] prices) {
        if (prices.length == 0) return 0;
        int prevHold = -prices[0], prevSold = 0; // state 1, 0
        for (int i = 1; i < prices.length; i++) {
            int currSold = Math.max(prevSold, prevHold + prices[i]); //dp[i][0]
            int currHold = Math.max(prevHold, prevSold - prices[i]); //dp[i][1]
            prevSold = currSold;
            prevHold = currHold;
        }
        return prevSold;
    }
    /*
    1 2 3 4 5

    -1

    -1 -1
    1  2


     */
}
