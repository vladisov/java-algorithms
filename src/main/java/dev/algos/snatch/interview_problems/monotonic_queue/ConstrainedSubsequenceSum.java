package dev.algos.snatch.interview_problems.monotonic_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.
 * <p>
 * A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, leaving the remaining elements in their original order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10,2,-10,5,20], k = 2
 * Output: 37
 * Explanation: The subsequence is [10, 2, 5, 20].
 * Example 2:
 * <p>
 * Input: nums = [-1,-2,-3], k = 1
 * Output: -1
 * Explanation: The subsequence must be non-empty, so we choose the largest number.
 * Example 3:
 * <p>
 * Input: nums = [10,-2,-10,-5,20], k = 2
 * Output: 23
 * Explanation: The subsequence is [10, -2, -5, 20].
 */
public class ConstrainedSubsequenceSum {

    /**
     * Time O(N)
     * Space O(K)
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        int ans = Integer.MIN_VALUE, max = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // keeping max in decreasing queue
            while (!deque.isEmpty() && i - k > deque.peekFirst()) {
                deque.pollFirst();
            }

            max = deque.isEmpty() ? 0 : Math.max(0, nums[deque.peekFirst()]);
            nums[i] = max + nums[i];

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
            ans = Math.max(nums[i], ans);
        }
        return ans;
    }

    /**
     * Time O(N)
     * Space O(N)
     */
    public int constrainedSubsetSumNotOptimized(int[] nums, int k) {
        int[] dp = new int[nums.length];
        int ans = Integer.MIN_VALUE, max = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && i - k > deque.peekFirst()) {
                deque.pollFirst();
            }
            max = deque.isEmpty() ? 0 : Math.max(0, dp[deque.peekFirst()]);
            dp[i] = max + nums[i];

            while (!deque.isEmpty() && dp[i] > dp[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    /**
     * TLE
     * Time O(N*K)
     * Space O(N)
     */
    public int constrainedSubsetSumTLE(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = Math.max(i - k, 0); j < i; j++) { // choose the max element in latest k elements, it's in range [i-k, i-1]
                max = Math.max(max, dp[j]);
            }
            dp[i] = arr[i] + max;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
