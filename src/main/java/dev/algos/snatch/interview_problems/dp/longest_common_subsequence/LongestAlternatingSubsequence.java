package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a number sequence, find the length of its Longest Alternating Subsequence (LAS). A subsequence is considered alternating if its elements are in alternating order.
 * <p>
 * A three element sequence (a1, a2, a3) will be an alternating sequence if its elements hold one of the following conditions:
 * <p>
 * {a1 > a2 < a3 } or { a1 < a2 > a3}.
 * Example 1:
 * <p>
 * Input: {1,2,3,4}
 * Output: 2
 * Explanation: There are many LAS: {1,2}, {3,4}, {1,3}, {1,4}
 * Example 2:
 * <p>
 * Input: {3,2,1,4}
 * Output: 3
 * Explanation: The LAS are {3,2,4} and {2,1,4}.
 * Example 3:
 * <p>
 * Input: {1,3,2,4}
 * Output: 4
 * Explanation: The LAS is {1,3,2,4}.
 */
public class LongestAlternatingSubsequence {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public int findLASLengthEducative(int[] nums) {
        if (nums.length == 0) return 0;
        //dp[i][0] = stores the LAS ending at 'i' such that the last two elements are in ascending order
        //dp[i][1] = stores the LAS ending at 'i' such that the last two elements are in descending order
        int[][] dp = new int[nums.length][2];
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            // every single element can be considered as LAS of length 1
            dp[i][0] = dp[i][1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // if nums[i] is BIGGER than nums[j] then we will consider the LAS ending at 'j' where the
                    // last two elements were in DESCENDING order
                    dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
                    maxLength = Math.max(maxLength, dp[i][0]);
                } else if (nums[i] != nums[j]) { // if the numbers are equal don't do anything
                    // if nums[i] is SMALLER than nums[j] then we will consider the LAS ending at 'j' where the
                    // last two elements were in ASCENDING order
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[j][0]);
                    maxLength = Math.max(maxLength, dp[i][1]);
                }
            }
        }
        return maxLength;
    }

    public int longestAlternatingSubsequenceBU(int[] arr) {
        int[] asc = new int[arr.length];
        int[] desc = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            asc[i] = 1;
            desc[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    // we need to check in desc array here since we want it to be alternating
                    asc[i] = Math.max(asc[j], desc[j] + 1);
                } else if (arr[i] != arr[j]) {
                    desc[i] = Math.max(desc[j], asc[j] + 1);
                }
                max = Math.max(max, Math.max(asc[i], desc[i]));
            }
        }
        return max;
    }

    public int longestAlternatingSubsequence(int[] arr) {
        Map<String, Integer> dp = new HashMap<>();
        return Math.max(las(arr, 0, -1, true, dp), las(arr, 0, -1, false, dp));
    }

    private int las(int[] arr, int curr, int prev, boolean greater, Map<String, Integer> dp) {
        if (curr >= arr.length) {
            return 0;
        }
        String key = curr + "_" + prev + "_" + greater;
        if (!dp.containsKey(key)) {
            boolean cond = prev == -1 || (greater ? arr[curr] > arr[prev] : arr[curr] < arr[prev]);
            int len1 = 0;
            if (cond) {
                len1 = 1 + las(arr, curr + 1, curr, !greater, dp);
            }
            int len2 = las(arr, curr + 1, prev, greater, dp);
            dp.put(key, Math.max(len1, len2));
        }
        return dp.get(key);
    }
}
