package dev.algos.snatch.interview_problems.monotonic_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 * Example 2:
 * <p>
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 * Example 3:
 * <p>
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 */
public class LargestContinuousSubarrayWithAbsDifferenceLessThanLimit {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int i = 0, j = 0, max = 0;
        for (; i < nums.length; i++) {
            // decreasing queue
            while (!maxDeque.isEmpty() && nums[i] > nums[maxDeque.peekLast()]) {
                maxDeque.pollLast();
            }
            // increasing queue
            while (!minDeque.isEmpty() && nums[i] < nums[minDeque.peekLast()]) {
                minDeque.pollLast();
            }
            minDeque.addLast(i);
            maxDeque.addLast(i);

            // check difference
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == j) maxDeque.pollFirst();
                if (minDeque.peekFirst() == j) minDeque.pollFirst();
                j++;
            }
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
