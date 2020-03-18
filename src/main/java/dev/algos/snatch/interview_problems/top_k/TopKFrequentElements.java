package dev.algos.snatch.interview_problems.top_k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 3, 5, 12, 11, 12, 11], K = 2
 * Output: [12, 11]
 * Explanation: Both '11' and '12' appeared twice.
 * Example 2:
 * <p>
 * Input: [5, 12, 11, 3, 11], K = 2
 * Output: [11, 5] or [11, 12] or [11, 3]
 * Explanation: Only '11' appeared twice, all other numbers appeared once.
 */
public class TopKFrequentElements {

    /**
     * Time complexity O(N + NlogK)
     * Space complexity O(K)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }
}
