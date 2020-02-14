package dev.algos.snatch.interview_problems.cyclic_sort;

import static dev.algos.snatch.interview_problems.helpers.ArrayUtils.swap;

/**
 * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
 * The array originally contained all the numbers from 1 to ‘n’, but due to a data error,
 * one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.
 * <p>
 * Example 1:
 * <p>
 * Input: [3, 1, 2, 5, 2]
 * Output: [2, 4]
 * Explanation: '2' is duplicated and '4' is missing.
 * Example 2:
 * <p>
 * Input: [3, 1, 2, 3, 6, 4]
 * Output: [3, 5]
 * Explanation: '3' is duplicated and '5' is missing.
 */
public class FindCorruptPair {

    public int[] findNumbers(int[] nums) {

        for (int i = 0; i < nums.length; ) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }

        return new int[]{-1, -1};
    }
}
