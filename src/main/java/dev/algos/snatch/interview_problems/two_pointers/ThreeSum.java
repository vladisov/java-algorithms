package dev.algos.snatch.interview_problems.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ### [15.3Sum](https://leetcode.com/problems/3sum/)
 * <p>
 * Difficulty: **Medium**
 * <p>
 * <p>
 * Given an array `nums` of _n_ integers, are there elements _a_, _b_, _c_ in `nums` such that _a_ + _b_ + _c_ = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * **Note:**
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * **Example:**
 * <p>
 * ```
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    /**
     * Time complexity
     * O(n^2)
     * Space complexity
     * O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1, k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        result.add(List.of(nums[i], nums[j], nums[k]));
                    }
                    if (sum <= 0) {
                        int start = j;
                        while (nums[start] == nums[j] && j < k) j++;
                    }
                    if (sum >= 0) {
                        int end = k;
                        while (nums[end] == nums[k] && j < k) k--;
                    }
                }
            }
        }
        return result;
    }
}
