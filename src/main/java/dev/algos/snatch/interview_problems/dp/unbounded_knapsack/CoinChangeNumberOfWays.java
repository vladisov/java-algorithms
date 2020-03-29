package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

/**
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 * <p>
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 * <p>
 * Input: amount = 10, coins = [10]
 * Output: 1
 */
public class CoinChangeNumberOfWays {

    /**
     * Time O(C * S)
     * Space O(S)
     */
    public int countChangeBUOptimized(int[] denominations, int total) {
        int[] dp = new int[total + 1];
        dp[0] = 1; //base case
        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for (int coin : denominations) {
            for (int j = coin; j <= total; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[total];
    }

    public int countChangeBU(int[] denominations, int total) {
        int[][] dp = new int[denominations.length][total + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int s = 1; s <= total; s++) {
            if (s % denominations[0] == 0) {
                dp[0][s] = 1;
            }
        }

        for (int i = 1; i < denominations.length; i++) {
            for (int j = 1; j <= total; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= denominations[i]) {
                    dp[i][j] += dp[i][j - denominations[i]];
                }
            }
        }
        return dp[denominations.length - 1][total];
    }

    public int countChangeMemo(int[] denominations, int total) {
        Integer[][] dp = new Integer[denominations.length][total + 1];
        return coinChangeRecMemo(denominations, total, 0, dp);
    }

    private int coinChangeRecMemo(int[] denominations, int total, int index, Integer[][] dp) {
        if (total == 0) {
            return 1;
        }
        if (index >= denominations.length) {
            return 0;
        }

        if (dp[index][total] == null) {
            int count1 = 0;
            if (total >= denominations[index]) {
                count1 = coinChangeRec(denominations, total - denominations[index], index);
            }
            int count2 = coinChangeRec(denominations, total, index + 1);
            dp[index][total] = count1 + count2;
        }
        return dp[index][total];
    }

    public int countChange(int[] denominations, int total) {
        return coinChangeRec(denominations, total, 0);
    }

    private int coinChangeRec(int[] denominations, int total, int index) {
        if (total == 0) {
            return 1;
        }
        if (index >= denominations.length) {
            return 0;
        }
        int count1 = 0;
        if (total >= denominations[index]) {
            count1 = coinChangeRec(denominations, total - denominations[index], index);
        }
        int count2 = coinChangeRec(denominations, total, index + 1);

        return count1 + count2;
    }
}
