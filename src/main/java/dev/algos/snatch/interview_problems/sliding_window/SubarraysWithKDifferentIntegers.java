package dev.algos.snatch.interview_problems.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of positive integers, call a (contiguous, not necessarily distinct)
 * subarray of A good if the number of different integers in that subarray is exactly K.
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * Return the number of good subarrays of A.
 * Example 1:
 * Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 */
public class SubarraysWithKDifferentIntegers {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    int atMostK(int[] arr, int k) {
        if (k == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0, count = 0;
        while (end < arr.length) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            end++;
            while (map.size() > k) {
                map.put(arr[start], map.getOrDefault(arr[start], 0) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }
            count += end - start; // trick here : we can add all subarrays between end and start
        }
        return count;
    }
}
