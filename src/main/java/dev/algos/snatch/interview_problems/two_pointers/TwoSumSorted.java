package dev.algos.snatch.interview_problems.two_pointers;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * <p>
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 * Example 2:
 * <p>
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class TwoSumSorted {

    /**
     * Time: O(n)
     * Space: O(1)
     */
    int[] search(int[] arr, int targetSum) {
        if (arr.length == 0) return new int[]{-1, -1};
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (sum == targetSum) {
                return new int[]{lo, hi};
            }
            if (arr[lo] + arr[hi] < targetSum) {
                lo++;
            } else {
                hi--;
            }
        }
        return new int[]{-1, -1};
    }
}
