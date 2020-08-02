package dev.algos.snatch.interview_problems.monotonic_queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
 * <p>
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 */
public class SubarrayMinimums {

    int mod = 1000000007;

    /**
     * Time O(N)
     * Space O(N)
     */
    public int sumSubarrayMins(int[] A) {
        int n = A.length;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        int[] prev = new int[n];
        int[] next = new int[n];
        Arrays.fill(next, n);
        Arrays.fill(prev, -1);
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                int prevIndex = stack.pop();
                next[prevIndex] = i;
            }
            if (!stack.isEmpty()) {
                prev[i] = stack.peek();
            }
            stack.add(i);
        }
        for (int i = 0; i < n; i++) {
            int left = i - prev[i];
            int right = next[i] - i;
            sum += (A[i] * (left * right)) % mod;
            sum %= mod;
        }
        return sum;
    }
}
