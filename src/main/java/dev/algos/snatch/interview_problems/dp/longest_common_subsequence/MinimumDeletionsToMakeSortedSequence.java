package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a number sequence, find the minimum number of elements that should be deleted to make the remaining sequence sorted.
 * <p>
 * Example 1:
 * <p>
 * Input: {4,2,3,6,10,1,12}
 * Output: 2
 * Explanation: We need to delete {4,1} to make the remaing sequence sorted {2,3,6,10,12}.
 * Example 2:
 * <p>
 * Input: {-4,10,3,7,15}
 * Output: 1
 * Explanation: We need to delete {10} to make the remaing sequence sorted {-4,3,7,15}.
 * Example 3:
 * <p>
 * Input: {3,2,1,0}
 * Output: 3
 * Explanation: Since the elements are in reverse order, we have to delete all except one to get a
 * sorted sequence. Sorted sequences are {3}, {2}, {1}, and {0}
 */
public class MinimumDeletionsToMakeSortedSequence {

    /**
     * Time O(N^2)
     * Space O(N)
     */
    public int minDeletionsBU(int[] arr) {
        return arr.length - findLIS(arr);
    }

    int findLIS(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = 1 + dp[j];
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int minDeletions(int[] arr) {
        Map<String, Integer> dp = new HashMap<>();
        return minDeletionsRec(arr, 0, -1, dp);
    }

    int minDeletionsRec(int[] arr, int curr, int prev, Map<String, Integer> dp) {
        if (curr >= arr.length) return 0;
        String key = prev + "_" + curr;
        if (!dp.containsKey(key)) {
            int min1 = Integer.MAX_VALUE;
            if (prev == -1 || arr[curr] > arr[prev]) {
                min1 = minDeletionsRec(arr, curr + 1, curr, dp);
            }
            int min2 = 1 + minDeletionsRec(arr, curr + 1, prev, dp);
            dp.put(key, Math.min(min1, min2));
        }
        return dp.get(key);
    }
}
