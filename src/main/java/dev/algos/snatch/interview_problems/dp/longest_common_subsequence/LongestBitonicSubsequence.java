package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a number sequence, find the length of its Longest Bitonic Subsequence (LBS).
 * A subsequence is considered bitonic if it is monotonically increasing and then monotonically decreasing.
 * <p>
 * Example 1:
 * <p>
 * Input: {4,2,3,6,10,1,12}
 * Output: 5
 * Explanation: The LBS is {2,3,6,10,1}.
 * Example 2:
 * <p>
 * Input: {4,2,5,9,7,6,10,3,1}
 * Output: 7
 * Explanation: The LBS is {4,5,9,7,6,3,1}
 */
public class LongestBitonicSubsequence {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    int longestBitonicSubsequenceBU(int[] arr) {
        int n = arr.length;
        int[] lds = new int[n];
        int[] ldsRev = new int[n];

        //go left
        for (int i = 0; i < n; i++) {
            lds[i] = 1; //for one letter min subsequence = 1
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    lds[i] = Math.max(lds[i], 1 + lds[j]);
                }
            }
        }

        //go right
        for (int i = n - 1; i >= 0; i--) {
            ldsRev[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    ldsRev[i] = Math.max(ldsRev[i], 1 + ldsRev[j]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, lds[i] + ldsRev[i] - 1);
        }
        return max;
    }


    int longestBitonicSubsequence(int[] arr) {
        int max = 0;
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 1; i < arr.length - 1; i++) {
            int left = lds(arr, i, -1, dp);
            int right = ldsReverse(arr, i, -1, dp);
            max = Math.max(left + right - 1, max);
        }
        return max;
    }

    private int ldsReverse(int[] arr, int curr, int prev, Map<String, Integer> dp) {
        if (curr < 0) {
            return 0;
        }

        String key = curr + "_" + prev + "_rev";
        if (!dp.containsKey(key)) {
            int c1 = 0;
            if (prev == -1 || arr[curr] < arr[prev]) {
                c1 = 1 + ldsReverse(arr, curr - 1, curr, dp);
            }
            int c2 = ldsReverse(arr, curr - 1, prev, dp);
            dp.put(key, Math.max(c1, c2));
        }
        return dp.get(key);
    }

    private int lds(int[] arr, int curr, int prev, Map<String, Integer> dp) {
        if (curr >= arr.length) {
            return 0;
        }

        String key = curr + "_" + prev;
        if (!dp.containsKey(key)) {
            int c1 = 0;
            if (prev == -1 || arr[curr] < arr[prev]) {
                c1 = 1 + lds(arr, curr + 1, curr, dp);
            }
            int c2 = lds(arr, curr + 1, prev, dp);
            dp.put(key, Math.max(c1, c2));
        }
        return dp.get(key);
    }
}
