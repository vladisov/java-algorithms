package dev.algos.snatch.interview_problems.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers arr and an integer target.
 * You have to find two non-overlapping sub-arrays of arr each with sum equal target. There can be multiple answers so you have to find an answer where the sum of the lengths of the two sub-arrays is minimum.
 * Return the minimum sum of the lengths of the two required sub-arrays, or return -1 if you cannot find such two sub-arrays.
 * Example 1:
 * Input: arr = [3,2,2,4,3], target = 3
 * Output: 2
 * Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.
 */
public class MinSumOfLengths {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, len = n;
        for (int i = 0; i < n; i++) {
            prefix[i] = len;
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                len = Math.min(len, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        map.clear();
        sum = 0;
        len = n;
        int min = n * 2;
        map.put(0, n);
        for (int i = n - 1; i >= 0; i--) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                len = Math.min(len, map.get(sum - target) - i);
            }
            map.put(sum, i);
            suffix[i] = len;
            if (suffix[i] != n && prefix[i] != n) {
                min = Math.min(suffix[i] + prefix[i], min);
            }
        }
        return min == n * 2 ? -1 : min;
    }
}
