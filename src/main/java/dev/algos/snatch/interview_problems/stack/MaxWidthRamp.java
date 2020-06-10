package dev.algos.snatch.interview_problems.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].  The width of such a ramp is j - i.
 * Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
 * Example 1:
 * Input: [6,0,8,2,1,5]
 * Output: 4
 * Explanation:
 * The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
 */
public class MaxWidthRamp {

    /**
     * Time O(NlogN)
     * Space O(N)
     */
    public int maxWidthRamp(int[] arr) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (list.isEmpty() || arr[i] < arr[list.get(list.size() - 1)]) {
                list.add(i);
            } else {
                int left = bs(list, arr, arr[i]);
                res = Math.max(res, i - list.get(left));
            }
        }
        return res;
    }

    private int bs(List<Integer> list, int[] arr, int target) {
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[list.get(mid)] > target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /*
    6,0,8,2,1,5
    6 0
     */

    /**
     * Time O(N)
     * Space O(N)
     */
    public int maxWidthRampOptimized(int[] arr) {
        int res = 0, n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            //go and create decreasing stack
            if (stack.isEmpty() || arr[i] < arr[stack.peek()]) {
                stack.add(i);
            }
        }

        for (int i = n - 1; i > res; i--) {
            //if value is greater than value in stack, pop from stack and calculate result
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                res = Math.max(res, i - stack.pop());
            }
        }

        return res;
    }
}
