package dev.algos.snatch.interview_problems.binary_search;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition {

    /**
     * Time O(logN)
     * Space O(1)
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int lo = 0, hi = nums.length - 1, index = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
                index = lo;
            } else {
                hi = mid - 1;
            }
        }
        return index;
    }
}
