package dev.algos.snatch.interview_problems.dp.knapsack;

/**
 * Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.
 * <p>
 * Example 1: #
 * Input: {1, 1, 2, 3}, S=4
 * Output: 3
 * The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
 * Note that we have two similar sets {1, 3}, because we have two '1' in our input.
 * Example 2: #
 * Input: {1, 2, 7, 1, 5}, S=9
 * Output: 3
 * The given set has '3' subsets whose sum is '9': {2, 7}, {1, 7, 1}, {1, 2, 1, 5}
 */
public class CountOfSubsetSum {

    /**
     * Time O(N * S)
     * Space O(S)
     */
    public int countSubsetsDPOptimized(int[] num, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1; // we can make zero sum with any number
        for (int i = 0; i <= sum; i++) {
            if (num[0] == i) {
                dp[i] = 1;
            }
        }
        for (int i = 1; i < num.length; i++) {
            for (int s = sum; s >= 0; s--) {
                if (s >= num[i]) {
                    dp[s] += dp[s - num[i]];
                }
            }
        }
        return dp[sum];
    }

    public int countSubsetsDP(int[] num, int sum) {
        int[][] dp = new int[num.length][sum + 1];
        for (int i = 0; i < num.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= sum; i++) {
            if (num[0] == i) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < num.length; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - num[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - num[i]];
                }
            }
        }
        return dp[num.length - 1][sum];
    }

    public int countSubsetsMemo(int[] num, int sum) {
        Integer[][] dp = new Integer[num.length][sum + 1];
        return this.countSubsetsRecursiveMemo(num, sum, 0, dp);
    }

    private int countSubsetsRecursiveMemo(int[] num, int sum, int i, Integer[][] dp) {
        if (sum == 0) {
            return 1;
        }
        if (i >= num.length) {
            return 0;
        }
        if (dp[i][sum] == null) {
            int count1 = 0;
            if (sum - num[i] >= 0) {
                count1 = countSubsetsRecursive(num, sum - num[i], i + 1);
            }
            int count2 = countSubsetsRecursive(num, sum, i + 1);
            dp[i][sum] = count1 + count2;
        }
        return dp[i][sum];
    }

    public int countSubsets(int[] num, int sum) {
        return this.countSubsetsRecursive(num, sum, 0);
    }

    private int countSubsetsRecursive(int[] num, int sum, int i) {
        if (sum == 0) {
            return 1;
        }
        if (i >= num.length) {
            return 0;
        }
        int count1 = 0;
        if (sum - num[i] >= 0) {
            count1 = countSubsetsRecursive(num, sum - num[i], i + 1);
        }
        int count2 = countSubsetsRecursive(num, sum, i + 1);
        return count1 + count2;
    }
}
