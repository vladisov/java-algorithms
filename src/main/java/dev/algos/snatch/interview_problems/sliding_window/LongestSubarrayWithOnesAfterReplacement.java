package dev.algos.snatch.interview_problems.sliding_window;

/**
 * Given an array containing 0s and 1s,
 * if you are allowed to replace no more than ‘k’ 0s with 1s,
 * find the length of the longest contiguous subarray having all 1s.
 * <p>
 * Example 1:
 * <p>
 * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
 * Output: 6
 * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 * Example 2:
 * <p>
 * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
 * Output: 9
 * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
 */
public class LongestSubarrayWithOnesAfterReplacement {

    /**
     * Time Complexity
     * The time complexity of the above algorithm will be O(N) where ‘N’ is the count of numbers in the input array.
     * <p>
     * Space Complexity
     * The algorithm runs in constant space O(1).
     */
    public int findLength(int[] arr, int k) {
        if (arr.length == 0) return 0;
        int start = 0, end = 0, zeros = 0, len = 0;
        while (end < arr.length) {
            int num = arr[end++];
            if (num == 0) zeros++;
            if (zeros > k) {
                num = arr[start++];
                if (num == 0) zeros--;
            }
            len = Math.max(end - start, len);
        }
        return len;
    }
}
