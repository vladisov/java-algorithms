package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange {

    public int countChangeBUOptimized(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin) {
                    int rem = i - coin;
                    if (dp[rem] != -1) {
                        dp[i] = Math.min(dp[i], 1 + dp[rem]);
                    }
                }
            }
            dp[i] = dp[i] == Integer.MAX_VALUE ? -1 : dp[i];
        }
        return dp[amount];
    }


    public int countChange(int[] denominations, int total) {
        Integer[][] dp = new Integer[denominations.length][total + 1];
        int result = coinChangeRec(denominations, total, 0, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int coinChangeRec(int[] denominations, int total, int index, Integer[][] dp) {
        if (total == 0) {
            return 0;
        }
        if (index >= denominations.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[index][total] == null) {
            int count1 = Integer.MAX_VALUE;
            if (total >= denominations[index]) {
                count1 = coinChangeRec(denominations, total - denominations[index], index, dp);
                if (count1 != Integer.MAX_VALUE) {
                    count1 += 1;
                }
            }
            int count2 = coinChangeRec(denominations, total, index + 1, dp);
            dp[index][total] = Math.min(count1, count2);
        }

        return dp[index][total];
    }
}
