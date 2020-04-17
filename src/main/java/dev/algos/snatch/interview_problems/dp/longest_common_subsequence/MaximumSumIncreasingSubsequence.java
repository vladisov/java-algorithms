package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement #
 * Given a number sequence, find the increasing subsequence with the highest sum. Write a method that returns the highest sum.
 * <p>
 * Example 1:
 * <p>
 * Input: {4,1,2,6,10,1,12}
 * Output: 32
 * Explanation: The increaseing sequence is {4,6,10,12}.
 * Please note the difference, as the LIS is {1,2,6,10,12} which has a sum of '31'.
 * Example 2:
 * <p>
 * Input: {-4,10,3,7,15}
 * Output: 25
 * Explanation: The increaseing sequences are {10, 15} and {3,7,15}.
 */
public class MaximumSumIncreasingSubsequence {

    int findMaxSumISBU(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int max = nums[0];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i]; // fill all with arr value
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(nums[i] + dp[j], dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /**
     * Memo
     * Time & Space O(N^2)
     */
    int findMaxSumIS(int[] arr) {
        Integer[][] dp = new Integer[arr.length + 1][arr.length + 1];
        return findMaxSumRec(arr, 0, -1, dp);
    }

    int findMaxSumRec(int[] arr, int curr, int prev, Integer[][] dp) {
        if (curr >= arr.length) {
            return 0;
        }

        if (dp[prev + 1][curr + 1] == null) {
            int s1 = 0;
            if (prev == -1 || arr[curr] > arr[prev]) {
                s1 = arr[curr] + findMaxSumRec(arr, curr + 1, curr, dp);
            }
            int s2 = findMaxSumRec(arr, curr + 1, prev, dp);
            dp[prev + 1][curr + 1] = Math.max(s1, s2);
        }
        return dp[prev + 1][curr + 1];
    }

    /**
     * Memo
     * Time & Space O(N^2)
     */
    int findMaxSumISMemo1(int[] arr) {
        Map<String, Integer> dp = new HashMap<>();
        return findMaxSumRecMemo1(arr, 0, -1, 0, dp);
    }

    int findMaxSumRecMemo1(int[] arr, int curr, int prev, int sum, Map<String, Integer> dp) {
        if (curr >= arr.length) {
            return sum;
        }

        String key = prev + "_" + curr + "_" + sum;
        if (!dp.containsKey(key)) {
            int s1 = 0;
            if (prev == -1 || arr[curr] > arr[prev]) {
                s1 = findMaxSumRecMemo1(arr, curr + 1, curr, sum + arr[curr], dp);
            }
            int s2 = findMaxSumRecMemo1(arr, curr + 1, prev, sum, dp);
            dp.put(key, Math.max(s1, s2));
        }
        return dp.get(key);
    }
}
