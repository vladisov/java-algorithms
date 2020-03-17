package dev.algos.snatch.interview_problems.top_k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));

        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (!visited.contains(num)) {
                maxHeap.add(num);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
                visited.add(num);
            }
        }
        return new ArrayList<>(maxHeap);
    }
}
