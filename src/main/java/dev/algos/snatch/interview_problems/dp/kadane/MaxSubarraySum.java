package dev.algos.snatch.interview_problems.dp.kadane;

public class MaxSubarraySum {

    /**
     * Time & Space O(N)
     */
    public int maxSubArrayDp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * Time O(N)
     * Space O(1)
     */
    public int maxSubArrayKadane(int[] nums) {
        int curr = nums[0], max = curr;
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(curr + nums[i], nums[i]);
            max = Math.max(curr, max);
        }
        return max;
    }
}
