package dev.algos.snatch.interview_problems.sliding_window;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
 * Return the number of nice sub-arrays.
 * Example 1:
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 */
public class CountNumberOfNiceSubarrays {

    /**
     * Sliding Window
     * Time O(N)
     * Space O(N)
     */
    public int numberOfSubarrays(int[] arr, int k) {
        if (k == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> odds = new ArrayDeque<>();
        int start = 0, end = 0, count = 0, res = 0;
        while (end < arr.length) {
            if (arr[end] % 2 != 0) {
                map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
                odds.addLast(end);
                count++;
            }
            end++;
            while (count > k) {
                if (arr[start] % 2 != 0) {
                    map.put(arr[start], map.getOrDefault(arr[start], 0) - 1);
                    count--;
                    odds.pollFirst();
                }
                start++;
            }
            if (count == k) {
                res += odds.peekFirst() - start + 1;
            }
        }
        return res;
    }

    /**
     * Prefix Sum
     * <p>
     * If we've seen sum - k before that means we added k odd numbers
     */
    /*
    1,1,2,1,1
    1 2 2 3 4
     */
    public int numberOfSubarraysPrefix(int[] arr, int k) {
        if (k == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // we've seen sum 0 once
        int sum = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] % 2 == 0 ? 0 : 1;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            res += map.getOrDefault(sum - k, 0);
        }
        return res;
    }

}
