package dev.algos.snatch.interview_problems.dp.kadane;

/**
 * Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.
 * <p>
 * Note that the subarray needs to be non-empty after deleting one element.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,-2,0,3]
 * Output: 4
 * Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.
 * Example 2:
 * <p>
 * Input: arr = [1,-2,-2,3]
 * Output: 3
 * Explanation: We just choose [3] and it's the maximum sum.
 * Example 3:
 * <p>
 * Input: arr = [-1,-1,-1,-1]
 * Output: -1
 * Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.
 */
public class MaximumSubarraySumAfterOneDeletion {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int maximumSum(int[] arr) {
        int[] noDel = new int[arr.length];
        int[] oneDel = new int[arr.length];
        noDel[0] = arr[0];
        int max = noDel[0];
        for (int i = 1; i < arr.length; i++) {
            noDel[i] = Math.max(noDel[i - 1] + arr[i], arr[i]);
            // we either take noDeletion previously calculated number(skipping current)
            // or continue adding sum
            oneDel[i] = Math.max(noDel[i - 1], oneDel[i - 1] + arr[i]);
            max = Math.max(noDel[i], max);
            max = Math.max(oneDel[i], max);
        }
        return max;
    }

    /**
     * Time O(N)
     * Space O(1)
     */
    public int maximumSumOptimized(int[] arr) {
        int noDel = arr[0], oneDel = 0, max = noDel;
        for (int i = 1; i < arr.length; i++) {
            int noDelPrev = noDel;
            noDel = Math.max(noDel + arr[i], arr[i]);
            oneDel = Math.max(noDelPrev, oneDel + arr[i]);
            max = Math.max(oneDel, max);
            max = Math.max(noDel, max);
        }
        return max;
    }
}
