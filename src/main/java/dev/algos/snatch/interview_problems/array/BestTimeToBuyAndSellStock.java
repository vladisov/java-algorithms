package dev.algos.snatch.interview_problems.array;

/**
 * ### [121.Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
 * <p>
 * Difficulty: **Easy**
 * <p>
 * <p>
 * Say you have an array for which the _i_<sup>th</sup> element is the price of a given stock on day _i_.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * **Example 1:**
 * <p>
 * ```
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * ```
 * <p>
 * **Example 2:**
 * <p>
 * ```
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int currMax, globalMax = 0, buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            currMax = prices[i] - buy;
            globalMax = Math.max(currMax, globalMax);
            buy = Math.min(prices[i], buy);
        }
        return globalMax;
    }
}
