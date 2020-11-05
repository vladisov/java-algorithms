package dev.algos.snatch.interview_problems.dp.minimax;

import java.util.Arrays;

public class StoneGame_IV {

    /**
     * Time O(N * sqrt(N))
     * Space O(N)
     */
    public boolean winnerSquareGame(int n) {
        return helper(n, 0, new Integer[n + 1][2]) > 0;
    }

    // 0 - min, 1 - max
    int helper(int n, int turn, Integer[][] dp) {
        if (n == 0) {
            return turn;
        }
        int next = Math.abs(turn - 1);
        if (dp[n][next] == null) {
            int ans = turn; // curr turn
            for (int i = 1; i * i <= n; i++) {
                if (next == 1) {
                    ans = Math.max(helper(n - i * i, next, dp), ans);
                } else {
                    ans = Math.min(helper(n - i * i, next, dp), ans);
                }
            }
            dp[n][next] = ans;
        }
        return dp[n][next];
    }


    /*



     */
    public boolean winnerSquareGameDp(int n) {
        int[][] dp = new int[n + 1][2];
        Arrays.fill(dp, new int[]{-1, -1});
        for (int i = 0; i <= n; i++) {
            for (int turn = 0; turn < 2; turn++) {
                int next = Math.abs(turn - 1);
                for (int j = 0; j * j <= n; j++) {
                    if (next == 1) {
                        dp[i][next] = Math.max(dp[i - j * j][next], dp[i][next]);
                    } else {
                        dp[i][next] = Math.min(dp[i - j * j][next], dp[i][next]);
                    }
                }
            }
        }
        return dp[n][0] > 0;
    }
}
