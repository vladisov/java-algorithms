package dev.algos.snatch.interview_problems.dp;

public class CoinChange2 {

    /**
     * @return number of ways to make sum s using non-repeated coins
     */
    public static int coinnonrep(int[] coins, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int coin : coins)
            for (int i = s; i >= coin; i--)
                dp[i] += dp[i - coin];
        return dp[s];
    }

    /**
     * Time complexity O(A * C)
     * Space complexity O(A * C)
     */
    public int change1(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1; //coz we can change 0 amount with any coins
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int s = 1; s <= amount; s++) {
                dp[i][s] = dp[i - 1][s]; //we add i  coin less and same sum
                if (s >= coins[i - 1]) {
                    dp[i][s] += dp[i][s - coins[i - 1]]; // and if we're here we take sum - coins[i - 1] and add to result
                }
            }
        }

        return dp[coins.length][amount];
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int s = 1; s <= amount; s++) {
                if (s >= coin) {
                    dp[s] += dp[s - coin];
                }
            }
        }
        return dp[amount];
    }
}
