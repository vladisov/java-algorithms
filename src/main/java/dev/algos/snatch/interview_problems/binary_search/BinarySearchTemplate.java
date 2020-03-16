package dev.algos.snatch.interview_problems.binary_search;

/**
 * Obviously O(n) time and O(1) space
 */
public class BinarySearchTemplate {

    /**
     * Template #1 (left <= right):
     * <p>
     * Most basic and elementary form of Binary Search
     * Search Condition can be determined without comparing to the element's neighbors (or use specific elements around it)
     * No post-processing required because at each step, you are checking to see if the element has been found.
     * If you reach the end, then you know the element is not found
     */
    public int classicBinarySearch(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Template #2 (left < right):
     * <p>
     * An advanced way to implement Binary Search.
     * Search Condition needs to access element's immediate right neighbor
     * Use element's right neighbor to determine if condition is met and decide whether to go left or right
     * Gurantees Search Space is at least 2 in size at each step
     * Post-processing required. Loop/Recursion ends when you have 1 element left. Need to assess if the remaining element meets the condition.
     */
    public int binarySearchRight(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        //post-processing step here
        if (lo != arr.length && arr[lo] == target) return lo;
        return -1;
    }

    /**
     * An alternative way to implement Binary Search
     * Search Condition needs to access element's immediate left and right neighbors
     * Use element's neighbors to determine if condition is met and decide whether to go left or right
     * Gurantees Search Space is at least 3 in size at each step
     * Post-processing required. Loop/Recursion ends when you have 2 elements left. Need to assess if the remaining elements meet the conditio
     */
    public int binarySearchLeftAndRight(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        //post-processing step here
        if (arr[lo] == target) return lo;
        if (arr[hi] == target) return hi;
        return -1;
    }
}
