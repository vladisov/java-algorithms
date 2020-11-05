package dev.algos.snatch.interview_problems.dp;

public class StudentAttendance_II {

    int mod = 1_000_000_007;

    public int checkRecord(int n) {
        return helper(n, 0, 0, new int[n + 1][3][2]) % mod;
    }

    private int helper(int n, int l, int a, int[][][] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n][l][a] == 0) {
            int sum = 0;
            if (a == 0) {
                sum = (sum + helper(n - 1, 0, a + 1, dp)) % mod;
            }
            sum %= mod;
            if (l < 2) {
                sum = (sum + helper(n - 1, l + 1, a, dp)) % mod;
            }
            sum = (sum + helper(n - 1, 0, a, dp)) % mod;
            dp[n][l][a] = sum;
        }
        return dp[n][l][a];
    }

    /*
     A = 0
        index
     l    0     1    2
     0    0     1    2
     1    0     1    2

          A = 1
        index
     l    0     1    2
     0    0     1    2
     1    0     1    2
     */
    public int checkRecordBottomUp(int n) {
        int[][][] dp = new int[n + 1][3][2];
        dp[n] = new int[][]{{1, 1}, {1, 1}, {1, 1}};
        for (int i = n - 1; i >= 0; i--) {
            for (int l = 0; l < 3; l++) {
                for (int a = 0; a < 2; a++) {
                    if (a == 0) {
                        dp[i][l][a] = (dp[i][l][a] + dp[i + 1][0][a + 1]) % mod;
                    }
                    if (l < 2) {
                        dp[i][l][a] = (dp[i][l][a] + dp[i + 1][l + 1][a]) % mod;
                    }
                    dp[i][l][a] = (dp[i][l][a] + dp[i + 1][0][a]) % mod;
                }
            }
        }
        return dp[0][0][0] % mod;
    }

    public int checkRecordBottomUpOptimized(int n) {
        int[][] prev = new int[][]{{1, 1}, {1, 1}, {1, 1}};
        for (int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[3][2];
            for (int l = 0; l < 3; l++) {
                for (int a = 0; a < 2; a++) {
                    if (a == 0) {
                        curr[l][a] = (curr[l][a] + prev[0][a + 1]) % mod;
                    }
                    if (l < 2) {
                        curr[l][a] = (curr[l][a] + prev[l + 1][a]) % mod;
                    }
                    curr[l][a] = (curr[l][a] + prev[0][a]) % mod;
                }
            }
            prev = curr;
        }
        return prev[0][0];
    }
}
