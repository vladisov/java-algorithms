package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

import java.util.Arrays;

/**
 * Introduction #
 * We are given a ribbon of length ‘n’ and a set of possible ribbon lengths.
 * Now we need to cut the ribbon into the maximum number of pieces that comply with the above-mentioned possible lengths.
 * Write a method that will return the count of pieces.
 * <p>
 * Example 1:
 * <p>
 * n: 5
 * Ribbon Lengths: {2,3,5}
 * Output: 2
 * Explanation: Ribbon pieces will be {2,3}.
 * Example 2:
 * <p>
 * n: 7
 * Ribbon Lengths: {2,3}
 * Output: 3
 * Explanation: Ribbon pieces will be {2,2,3}.
 * Example 3:
 * <p>
 * n: 13
 * Ribbon Lengths: {3,5,7}
 * Output: 3
 * Explanation: Ribbon pieces will be {3,3,7}.
 */
public class MaximumRibbonCut {

    int maxRibbonCutBUOptimized(int[] lengths, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            for (int len : lengths) {
                if (i >= len) {
                    int remaining = i - len;
                    if (dp[remaining] != -1) {
                        dp[i] = Math.max(dp[remaining] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[n];
    }

    /**
     * Time and Space = O(L * N)
     */
    int maxRibbonCutBU(int[] lengths, int n) {
        int[][] dp = new int[lengths.length][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        for (int i = 0; i < lengths.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            if (i >= lengths[0] && i % lengths[0] == 0) {
                dp[0][i] = i / lengths[0];
            }
        }
        for (int i = 1; i < lengths.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= lengths[i] && dp[i][j - lengths[i]] != -1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - lengths[i]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[lengths.length - 1][n];
    }

    int maxRibbonCut(int[] lengths, int n) {
        Integer[][] dp = new Integer[lengths.length][n + 1];
        int result = maxRibbonCut(lengths, n, 0, dp);
        return result == Integer.MIN_VALUE ? -1 : result;
    }

    private int maxRibbonCut(int[] lengths, int n, int i, Integer[][] dp) {
        if (n == 0) {
            return 0;
        }
        if (i >= lengths.length) {
            return Integer.MIN_VALUE;
        }
        int count1 = Integer.MIN_VALUE;
        if (dp[i][n] == null) {
            if (n >= lengths[i]) {
                count1 = maxRibbonCut(lengths, n - lengths[i], i, dp);
                if (count1 != Integer.MIN_VALUE) {
                    count1 += 1;
                }
            }
            int count2 = maxRibbonCut(lengths, n, i + 1, dp);
            dp[i][n] = Math.max(count1, count2);
        }
        return dp[i][n];
    }
}
