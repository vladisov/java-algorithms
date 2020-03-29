package dev.algos.snatch.interview_problems.dp.knapsack;

/**
 * Given a set of positive numbers, determine if a subset exists whose sum is equal to a given number ‘S’.
 * <p>
 * Example 1: #
 * Input: {1, 2, 3, 7}, S=6
 * Output: True
 * The given set has a subset whose sum is '6': {1, 2, 3}
 * Example 2: #
 * Input: {1, 2, 7, 1, 5}, S=10
 * Output: True
 * The given set has a subset whose sum is '10': {1, 2, 7}
 * Example 3: #
 * Input: {1, 3, 4, 8}, S=6
 * Output: False
 * The given set does not have any subset whose sum is equal to '6'.
 */
public class SubsetSum {

    /**
     * Time O(N * S)
     * Space O(S)
     */
    public boolean canPartition(int[] num, int sum) {
        Boolean[] dp = new Boolean[sum + 1];
        for (int i = 0; i < sum + 1; i++) {
            dp[i] = num[0] == i;
        }

        for (int i = 1; i < num.length; i++) {
            for (int j = sum; j > 0; j--) {
                if (num[i] <= sum) {
                    dp[j] = dp[j - num[i]] || dp[j];
                }
            }
        }
        return dp[sum];
    }
}
