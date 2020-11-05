package dev.algos.snatch.interview_problems.cyclic_sort;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/missing-number/">268. Missing Number</a>
 */
public class FirstSmallestMissingPositive {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int j = nums[i] - 1; //one based index
            if (j < nums.length && j >= 0 && nums[j] != nums[i]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
