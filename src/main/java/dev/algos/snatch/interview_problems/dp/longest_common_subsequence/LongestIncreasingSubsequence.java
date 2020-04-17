package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLISOptimized(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    arr[i] = Math.max(arr[j], arr[i]);
                }
            }
            arr[i] += 1;
        }
        int max = 0;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        return max;
    }

    public int lengthOfLISLenBU(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) { // if there are no other bigger increasing subsequence from dp[j]
                    dp[i] = 1 + dp[j];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public int lengthOfLISLenBUMy(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length + 1][nums.length + 1];
        return lengthOfLISRec(nums, 0, -1, dp);
    }

    int lengthOfLISRec(int[] nums, int curr, int prev, Integer[][] dp) {
        if (curr >= nums.length) {
            return 0;
        }

        if (dp[curr + 1][prev + 1] == null) {
            int c1 = 0;
            if (prev == -1 || nums[curr] > nums[prev]) {
                c1 = 1 + lengthOfLISRec(nums, curr + 1, curr, dp);
            }
            int c2 = lengthOfLISRec(nums, curr + 1, prev, dp);
            dp[curr + 1][prev + 1] = Math.max(c1, c2);
        }
        return dp[curr + 1][prev + 1];
    }
}
