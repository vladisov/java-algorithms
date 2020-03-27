package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

/**
 * Given a rod of length ‘n’, we are asked to cut the rod and sell the pieces in a way that will maximize the profit.
 * We are also given the price of every piece of length ‘i’ where ‘1 <= i <= n’.
 * <p>
 * Example:
 * <p>
 * Lengths: [1, 2, 3, 4, 5]
 * Prices: [2, 6, 7, 10, 13]
 * Rod Length: 5
 * <p>
 * Let’s try different combinations of cutting the rod:
 * <p>
 * Five pieces of length 1 => 10 price
 * Two pieces of length 2 and one piece of length 1 => 14 price
 * One piece of length 3 and two pieces of length 1 => 11 price
 * One piece of length 3 and one piece of length 2 => 13 price
 * One piece of length 4 and one piece of length 1 => 12 price
 * One piece of length 5 => 13 price
 * <p>
 * This shows that we get the maximum price (14) by cutting the rod into two pieces of length ‘2’ and one piece of length ‘1’.Ò
 */
public class RodCutting {

    /**
     * Time and Space O(N * S)
     */
    public int solveRodCutting(int[] lengths, int[] prices, int n) {
        int[][] dp = new int[lengths.length][n + 1];
        for (int i = 0; i <= n; i++) {
            if (i >= lengths[0]) {
                dp[0][i] = (i / lengths[0]) * prices[0];
            }
        }
        for (int i = 1; i < lengths.length; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= lengths[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], prices[i] + dp[i][j - lengths[i]]);
                }
            }
        }

        return dp[lengths.length - 1][n];
    }
}
