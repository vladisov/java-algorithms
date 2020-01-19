package dev.algos.snatch.interview_problems.sliding_window;

/**
 * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
 * Example 2:
 * <p>
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
 * Example 3:
 * <p>
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
 */
public class SmallestSubarrayWithGivenSum {

    /**
     * Time Complexity
     * The time complexity of the above algorithm will be O(n)
     * The outer for loop runs for all elements and the inner while loop processes each element only once,
     * therefore the time complexity of the algorithm will be O(N+N)
     * which is asymptotically equivalent to O(n)
     * <p>
     * Space Complexity
     * O(1)
     */
    public int findMinSubArray(int S, int[] arr) {
        if (arr.length == 0) return 0;

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int hi = 0, lo = 0; hi < arr.length; hi++) {
            sum += arr[hi];
            while (sum >= S) {
                min = Math.min(min, hi - lo + 1);
                sum -= arr[lo++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
