package dev.algos.snatch.interview_problems.dp.minimax;

public class StoneGame_IV {

    /**
     * Time O(N * sqrt(N))
     * Space O(N)
     */
    public boolean winnerSquareGame(int n) {
        Integer[][] dp = new Integer[n + 1][2];
        return helper(n, 0, dp) > 0;
    }

    private int helper(int n, int id, Integer[][] dp) {
        if (n == 0) {
            return id == 1 ? 1 : -1;
        }
        id = Math.abs(id - 1);
        if (dp[n][id] == null) {
            int max = id == 1 ? -1 : 1;
            for (int i = 1; i * i <= n; i++) {
                if (id == 1) {
                    max = Math.max(max, helper(n - i * i, id, dp));
                } else {
                    max = Math.min(max, helper(n - i * i, id, dp));
                }
            }
            dp[n][id] = max;
        }

        return dp[n][id];
    }
}
