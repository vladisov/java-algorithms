package dev.algos.snatch.interview_problems.miscellaneous;

/**
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 * <p>
 * What is the most number of chunks we could have made?
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 */
public class MaxChunksToMakeSorted {

    /**
     * Time O(N)
     * Space O(N) for recurison stack
     */
    public int maxChunksToSorted(int[] arr) {
        return helper(arr, 0);
    }

    int helper(int[] arr, int i) {
        if (i == arr.length) return 0;
        int max = arr[i];
        for (int j = i; j <= max; j++) {
            max = Math.max(arr[j], max);
        }
        return 1 + helper(arr, max + 1);
    }
}
