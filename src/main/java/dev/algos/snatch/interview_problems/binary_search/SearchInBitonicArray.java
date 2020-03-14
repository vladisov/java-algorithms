package dev.algos.snatch.interview_problems.binary_search;

/**
 * Given a Bitonic array, find if a given ‘key’ is present in it.
 * An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
 * Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
 * <p>
 * Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 3, 8, 4, 3], key=4
 * Output: 3
 * Example 2:
 * <p>
 * Input: [3, 8, 3, 1], key=8
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1, 3, 8, 12], key=12
 * Output: 3
 * Example 4:
 * <p>
 * Input: [10, 9, 8], key=10
 * Output: 0
 */
public class SearchInBitonicArray {

    /**
     * Time complexity O(3logn) = O(logn)
     * Space complexity O(1)
     */
    public int search(int[] arr, int key) {
        int pivot = findPivot(arr);
        int index = search(arr, key, 0, pivot, true);
        if (index != -1) {
            return index;
        }
        return search(arr, key, pivot + 1, arr.length - 1, false);
    }

    private int findPivot(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= arr[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int search(int[] arr, int key, int lo, int hi, boolean ascending) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                if (ascending) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (ascending) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }

        return -1;
    }
}
