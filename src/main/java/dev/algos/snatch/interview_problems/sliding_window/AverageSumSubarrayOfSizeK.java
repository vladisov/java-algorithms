package dev.algos.snatch.interview_problems.sliding_window;

/**
 * Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
 * Example:
 * Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
 * Output: [2.2, 2.8, 2.4, 3.6, 2.8]
 */
public class AverageSumSubarrayOfSizeK {

    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(1)
     */
    public double[] findAverages(int[] arr, int k) {
        if (arr.length == 0 || k == 0 || k > arr.length) return new double[]{};
        int lo = 0;
        double[] res = new double[arr.length - k + 1];
        double sum = 0;
        for (int hi = 0; hi < arr.length; hi++) {
            sum += arr[hi];
            if (hi >= k - 1) {
                res[lo] = sum / k;
                sum -= arr[lo++];
            }
        }
        return res;
    }
}
