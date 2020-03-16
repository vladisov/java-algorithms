package dev.algos.snatch.interview_problems.binary_search;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindInRange {

    /**
     * Time O(logn)
     * Space O(1)
     */
    public int[] searchRange(int[] arr, int target) {
        int[] res = new int[2];
        res[0] = findInRange(arr, target, true);
        res[1] = findInRange(arr, target, false);
        return res;
    }

    private int findInRange(int[] arr, int target, boolean low) {
        int lo = 0, hi = arr.length - 1, keyIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                keyIndex = mid;
                if (low) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return keyIndex;
    }
}
