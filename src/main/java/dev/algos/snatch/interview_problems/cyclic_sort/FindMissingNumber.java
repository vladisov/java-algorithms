package dev.algos.snatch.interview_problems.cyclic_sort;

import static dev.algos.snatch.interview_problems.helpers.ArrayUtils.swap;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/missing-number/">268. Missing Number</a>
 */
public class FindMissingNumber {

    public int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    public int findMissingNumberXor(int[] nums) {
        int x1 = 0;
        for (int i = 1; i <= nums.length; i++) {
            x1 = x1 ^ i;
        }
        int x2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x2 = x2 ^ nums[i];
        }
        return x1 ^ x2;
    }
}
