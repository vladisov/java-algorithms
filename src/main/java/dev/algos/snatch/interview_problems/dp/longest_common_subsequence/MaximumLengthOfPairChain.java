package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
 * <p>
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
 * <p>
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
 * <p>
 * Example 1:
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 */
public class MaximumLengthOfPairChain {

    public int findLongestChainBU(int[][] pairs) {
        if (pairs.length == 0) return 0;
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length, max = 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
                max = Math.max(dp[j], max);
            }
        }
        return max;
    }

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    int findLongestChainRecursive(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        int n = pairs.length;
        Integer[][] dp = new Integer[n + 1][n + 1];
        return helper(pairs, -1, 0, dp);
    }

    int helper(int[][] pairs, int prev, int index, Integer[][] dp) {
        if (index == pairs.length) {
            return 0;
        }
        if (dp[prev + 1][index + 1] == null) {
            int len1 = 0;
            if (prev == -1 || pairs[index][0] > pairs[prev][1]) {
                len1 = 1 + helper(pairs, index, index + 1, dp);
            }
            int len2 = helper(pairs, prev, index + 1, dp);
            dp[prev + 1][index + 1] = Math.max(len2, len1);
        }
        return dp[prev + 1][index + 1];
    }
}
