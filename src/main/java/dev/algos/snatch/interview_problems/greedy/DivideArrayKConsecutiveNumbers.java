package dev.algos.snatch.interview_problems.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
 * Return True if its possible otherwise return False.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4
 * Output: true
 * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
 */
public class DivideArrayKConsecutiveNumbers {

    /**
     * Time O(N + MlogM)
     * Space O(M)
     */
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0 || k > nums.length) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(map.keySet());
        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (map.get(num) > 0) {
                for (int i = k - 1; i > 0; i--) {
                    int next = num + i;
                    if (!map.containsKey(next) || map.getOrDefault(next, 0) < map.get(num)) return false;
                    map.put(next, map.get(next) - map.get(num));
                }
            }
        }
        return true;
    }
}
