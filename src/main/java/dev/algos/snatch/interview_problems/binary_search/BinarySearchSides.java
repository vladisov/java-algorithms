package dev.algos.snatch.interview_problems.binary_search;

public class BinarySearchSides {

    /**
     * Finds right side
     * Works if element is present
     */
    public int binarySearchRight(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
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
     * Works if element is present
     */
    public int binarySearchLeft(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
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

    /**
     * Finds less than left
     */
    public int binarySearchFloor(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        int floor = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target <= arr[mid]) {
                hi = mid - 1;
            } else {
                floor = arr[mid];
                lo = mid + 1;
            }
        }
        return floor;
    }

    /**
     * Finds greater than right
     */
    public int binarySearchCeil(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        int ceil = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < arr[mid]) {
                ceil = arr[mid];
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ceil;
    }

    /**
     * Finds less than left or equal
     */
    public int binarySearchFloorOrEqual(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target <= arr[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (lo == arr.length || arr[lo] > target) {
            return lo - 1;
        }
        return lo;
    }

    /**
     * Finds greater than right or equal
     */
    public int binarySearchCeilOrEqual(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target >= arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (hi == -1 || arr[hi] < target) {
            return hi + 1;
        }
        return hi;
    }
}
