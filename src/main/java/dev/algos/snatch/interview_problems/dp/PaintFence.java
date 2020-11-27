package dev.algos.snatch.interview_problems.dp;

public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        return helper(n, 0, 0, k, new Integer[n][3]);
    }

    int helper(int n, int i, int same, int k, Integer[][] dp) {
        if (i == n) return 1;
        int total = 0;
        if (dp[i][same] != null) {
            return dp[i][same];
        }
        switch (same) {
            case 2:
                for (int j = 1; j < k; j++) {
                    total += helper(n, i + 1, 1, k, dp);
                }
                break;
            case 1:
                total += helper(n, i + 1, 2, k, dp);
                for (int j = 1; j < k; j++) {
                    total += helper(n, i + 1, 1, k, dp);
                }
                break;
            case 0:
                for (int j = 0; j < k; j++) {
                    total += helper(n, i + 1, 1, k, dp);
                }
        }
        dp[i][same] = total;
        return dp[i][same];
    }

    public int numWaysBUFirst(int n, int k) {
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][3];
        dp[n][0] = dp[n][1] = dp[n][2] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 2; j++) {
                int start = j == 0 ? 0 : 1;
                if (j == 1) {
                    dp[i][j] += dp[i + 1][2];
                }
                for (int l = start; l < k; l++) {
                    dp[i][j] += dp[i + 1][1];
                }
            }
        }
        return dp[0][0];
    }

    public int numWaysBU(int n, int k) {
        if (n == 0) return 0;
        int[][] dp = new int[n + 1][3];
        dp[n][0] = dp[n][1] = dp[n][2] = 1;
        for (int i = n - 1; i >= 0; i--) {
            dp[i][0] += k * dp[i + 1][1];
            dp[i][1] += (k - 1) * dp[i + 1][1] + dp[i + 1][2];
            dp[i][2] += (k - 1) * dp[i + 1][1];
        }
        return dp[0][0];
    }

    public int numWaysBUSpace(int n, int k) {
        if (n == 0) return 0;
        int nextZero = 1, nextOne = 1, nextTwo = 1;
        for (int i = n - 1; i >= 0; i--) {
            int currZero = k * nextOne;
            int currOne = (k - 1) * nextOne + nextTwo;
            int currTwo = (k - 1) * nextOne;
            nextZero = currZero;
            nextOne = currOne;
            nextTwo = currTwo;
        }
        return nextZero;
    }

    public int numWaysBUSpaceShort(int n, int k) {
        if (n == 0) return 0;
        int po = 1, pt = 1;
        for (int i = n - 1; i > 0; i--) {
            po = (k - 1) * po + pt;
            pt = po - pt;
        }
        return po * k;
    }
}
