package dev.algos.snatch.interview_problems.top_k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Problem Statement #
 * Given an array of numbers and a number ‘K’, we need to remove ‘K’ numbers from the array such that we are left with maximum distinct numbers.
 * <p>
 * Example 1:
 * <p>
 * Input: [7, 3, 5, 8, 5, 3, 3], and K=2
 * Output: 3
 * Explanation: We can remove two occurrences of 3 to be left with 3 distinct numbers [7, 3, 8], we have
 * to skip 5 because it is not distinct and occurred twice.
 * Another solution could be to remove one instance of '5' and '3' each to be left with three
 * distinct numbers [7, 5, 8], in this case, we have to skip 3 because it occurred twice.
 * Example 2:
 * <p>
 * Input: [3, 5, 12, 11, 12], and K=3
 * Output: 2
 * Explanation: We can remove one occurrence of 12, after which all numbers will become distinct. Then
 * we can delete any two numbers which will leave us 2 distinct numbers in the result.
 * Example 3:
 * <p>
 * Input: [1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5], and K=2
 * Output: 3
 * Explanation: We can remove one occurrence of '4' to get three distinct numbers.
 */
public class MaximumDistinctElements {

    /**
     * Time O(NlogK + N + N)
     * Space O(N)
     */
    public int findMaximumDistinctElements(int[] nums, int k) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                queue.add(entry);
                if (queue.size() > k) {
                    queue.poll();
                }
            }
        }

        List<Map.Entry<Integer, Integer>> queueValues = new ArrayList<>(queue);

        for (int i = queueValues.size() - 1; i >= 0 && k > 0; k--) {
            Map.Entry<Integer, Integer> entry = queueValues.get(i);
            map.put(entry.getKey(), entry.getValue() - 1);
            if (map.get(entry.getKey()) == 1) {
                i--;
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
        }
        return Math.max(count - k, 0);
    }
}
