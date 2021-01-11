package dev.algos.snatch.interview_problems.dp.matrix_dp;

public class GuessNumberHigherOrLower {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int getMoneyAmount(int n) {
        return helper(1, n, new Integer[n + 1][n + 1]);
    }

    private int helper(int lo, int hi, Integer[][] dp) {
        if (lo == hi) return 0;
        if (dp[lo][hi] != null) return dp[lo][hi];
        int ans = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            ans = Math.min(ans, Math.max(i + helper(lo, i - 1, dp), i + helper(i + 1, hi, dp)));
        }
        return dp[lo][hi] = ans;
    }
}
