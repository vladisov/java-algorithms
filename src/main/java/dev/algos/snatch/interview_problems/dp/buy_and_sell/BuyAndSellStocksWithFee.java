package dev.algos.snatch.interview_problems.dp.buy_and_sell;

/**
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
 * <p>
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 * <p>
 * Return the maximum profit you can make.
 * <p>
 * Example 1:
 * Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * Buying at prices[0] = 1
 * Selling at prices[3] = 8
 * Buying at prices[4] = 4
 * Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 */
public class BuyAndSellStocksWithFee {

    public int maxProfit(int[] prices, int fee) {
        int days = prices.length;
        int[] buy = new int[days]; // state if we in buy mode, means we can buy and we have right to sell on next day
        int[] sell = new int[days]; // state if we in sell mode, we can sell and we have right to buy on next day
        buy[0] = -prices[0]; // we buy a stock on day 0
        for (int i = 1; i < days; i++) {
            // we can do nothing OR we have right to buy here and we buy from sell[i - 1]
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            // we do nothing OR we can sell here, so we take last buy status and apply logic
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[days - 1];
    }
}
