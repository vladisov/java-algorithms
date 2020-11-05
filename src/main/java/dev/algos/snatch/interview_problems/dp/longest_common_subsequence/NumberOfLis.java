package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

/**
 * Given an integer array nums, return the number of longest increasing subsequences.
 * Example 1:
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences'
 */
public class NumberOfLis {

    /**
     * Time O(N^2)
     * Space O(N*2)
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int len = 1, count = 0;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i][0] < dp[j][0] + 1) {
                        dp[i][0] = dp[j][0] + 1;
                        dp[i][1] = dp[j][1];
                    } else if (dp[i][0] == dp[j][0] + 1) {
                        dp[i][1] += dp[j][1];
                    }
                }
            }
            if (dp[i][0] > len) {
                len = dp[i][0];
                count = dp[i][1];
            } else if (dp[i][0] == len) {
                count += dp[i][1];
            }
        }
        return count;
    }
}
