package dev.algos.snatch.interview_problems.binary_search;

public class BinarySearchSides {

    /**
     * Finds right side
     */
    public int binarySearchRight(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        //post-processing step here
        if (lo != arr.length && arr[lo] == target) return lo;
        return -1;
    }

    /**
     * Finds left side
     */
    public int binarySearchLeft(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (arr[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        //post-processing step here
        if (lo != arr.length && arr[lo] == target) return lo;
        return -1;
    }

}
