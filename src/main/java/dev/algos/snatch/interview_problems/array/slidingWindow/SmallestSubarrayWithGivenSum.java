package dev.algos.snatch.interview_problems.array.slidingWindow;

/**
 * Given an array of positive numbers and a positive number ‘S’,
 * find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
 * Return 0, if no such subarray exists.
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class SmallestSubarrayWithGivenSum {

    int findMinSubArray(int[] arr, int s) {
        int sum = 0;
        int windowStart = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum >= s) {
                result = Math.min(result, i - windowStart + 1);
                sum -= arr[windowStart];
                windowStart++;
            }
        }
        return result;
    }
}
