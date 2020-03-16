package dev.algos.snatch.interview_problems.binary_search;

/**
 * ### [153.Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
 * <p>
 * Difficulty: **Medium**
 * <p>
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  `[0,1,2,4,5,6,7]` might become  `[4,5,6,7,0,1,2]`).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * **Example 1:**
 * <p>
 * ```
 * Input: [3,4,5,1,2]
 * Output: 1
 * ```
 * <p>
 * **Example 2:**
 * <p>
 * ```
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * ```
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * Time complexity
     * O(logn)
     * Space complexity
     * O(1)
     */
    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int hi = nums.length - 1;
        int lo = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }

    public int findMinWithDuplicates(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] == nums[mid] && nums[hi] == nums[mid]) {
                lo++;
                hi--;
            } else if (nums[mid] <= nums[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[lo];
    }
}
