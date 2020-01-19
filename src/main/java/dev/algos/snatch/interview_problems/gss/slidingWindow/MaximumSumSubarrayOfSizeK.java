package dev.algos.snatch.interview_problems.gss.slidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘k’,
 * find the maximum sum of any contiguous subarray of size ‘k’.
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class MaximumSumSubarrayOfSizeK {

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
