package dev.algos.snatch.interview_problems.binary_search;

/**
 * Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.
 * <p>
 * You can assume that the array does not have any duplicates.
 * <p>
 * Example 1:
 * <p>
 * Input: [10, 15, 1, 3, 8]
 * Output: 2
 * Explanation: The array has been rotated 2 times.
 */
public class RotationCountOfArray {


    /**
     * Time O(logn)
     * Space O(1)
     */
    public int countRotations(int[] arr) {
        return findMin(arr);
    }

    private int findMin(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < arr[hi]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public int countRotationsEd(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) // if mid is greater than the next element
                return mid + 1;
            if (mid > start && arr[mid - 1] > arr[mid]) // if mid is smaller than the previous element
                return mid;

            if (arr[start] < arr[mid]) { // left side is sorted, so the pivot is on right side
                start = mid + 1;
            } else { // right side is sorted, so the pivot is on the left side
                end = mid - 1;
            }
        }
        return 0; // the array has not been rotated
    }
}
