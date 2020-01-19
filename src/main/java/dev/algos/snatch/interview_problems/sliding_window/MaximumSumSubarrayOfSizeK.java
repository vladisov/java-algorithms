package dev.algos.snatch.interview_problems.sliding_window;

/**
 * Problem Statement
 * Given an array of numbers and a number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 * Example 2:
 * <p>
 * Input: [2, 3, 4, 1, 5], k=2
 * Output: 7
 * Explanation: Subarray with maximum sum is [3, 4].
 */
public class MaximumSumSubarrayOfSizeK {
    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(n)
     */
    public int findMaxSumSubArray(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return 0;
        int max = 0;
        for (int hi = 0, lo = 0, sum = 0; hi < arr.length; hi++) {
            sum += arr[hi];
            if (hi == k - 1) {
                max = sum;
                sum -= arr[lo++];
            } else if (hi > k - 1) {
                max = Math.max(sum, max);
                sum -= arr[lo++];
            }
        }
        return max;
    }

    int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0;
        int windowStart = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            windowSum += arr[i];
            if (i >= k - 1) {
                sum = Math.max(sum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return sum;
    }
}
