package dev.algos.snatch.interview_problems.binary_search;


/**
 * Find the maximum value in a given Bitonic array. An array is considered bitonic if it is monotonically increasing and then monotonically decreasing.
 * Monotonically increasing or decreasing means that for any index i in the array arr[i] != arr[i+1].
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 3, 8, 12, 4, 2]
 * Output: 12
 * Explanation: The maximum number in the input bitonic array is '12'.
 * Example 2:
 * <p>
 * Input: [3, 8, 3, 1]
 * Output: 8
 * Example 3:
 * <p>
 * Input: [1, 3, 8, 12]
 * Output: 12
 * Example 4:
 * <p>
 * Input: [10, 9, 8]
 * Output: 10
 */
public class BitonicArrayMaximum {

    /**
     * Time O(logN)
     * Space O(1)
     */
    public int findMax(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= arr[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return arr[lo];
    }
}
