package dev.algos.snatch.interview_problems.binary_search;


/**
 * Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
 * Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
 * You should assume that the array can have duplicates.
 * <p>
 * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
 */
public class OrderAgnosticBinarySearch {

    /**
     * Time complexity O(logn)
     * Space complexity O(1)
     */
    public int search(int[] arr, int key) {
        if (arr[0] < arr[arr.length - 1]) {
            return binarySearch(arr, key, true);
        }
        return binarySearch(arr, key, false);
    }

    private int binarySearch(int[] arr, int key, boolean asc) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                if (asc) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (asc) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }
}
