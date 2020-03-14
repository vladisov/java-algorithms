package dev.algos.snatch.interview_problems.binary_search;

/**
 * ### [33\. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)
 * <p>
 * Difficulty: **Medium**
 * <p>
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return `-1`.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of _O_(log _n_).
 * <p>
 * **Example 1:**
 * <p>
 * ```
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * ```
 * <p>
 * **Example 2:**
 * <p>
 * ```
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * ```
 */
public class SearchInRotatedSortedArray {

    /**
     * Time complexity
     * O(logn)
     * Space complexity
     * O(1)
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int hi = nums.length - 1;
        int lo = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            if (nums[mid] <= nums[hi]) {
                if (target <= nums[hi] && target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * The same with duplicates
     * Worst time complexity might be O(N)
     */
    public boolean searchWithDuplicates(int[] nums, int target) {
        if (nums.length == 0) return false;
        int hi = nums.length - 1;
        int lo = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // the only difference from the previous solution,
            // if numbers at indexes start, mid, and end are same, we can't choose a side
            // the best we can do, is to skip one number from both ends as key != arr[mid]
            if (nums[lo] == nums[mid] && nums[hi] == nums[mid]) {
                lo++;
                hi--;
            } else if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] <= nums[hi]) {
                if (target <= nums[hi] && target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
}
