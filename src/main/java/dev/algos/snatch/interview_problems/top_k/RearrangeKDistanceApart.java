package dev.algos.snatch.interview_problems.top_k;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeKDistanceApart {

    /**
     * Time complexity O(NlogN)
     * Space complexity O(N)
     */
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return s;
        Map<Character, Integer> frequency = new HashMap<>(); // char to index
        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

        maxHeap.addAll(frequency.entrySet());

        StringBuilder sb = new StringBuilder(s.length());
        while (!maxHeap.isEmpty()) {
            var currEntry = maxHeap.poll();
            sb.append(currEntry.getKey());
            currEntry.setValue(currEntry.getValue() - 1);
            queue.add(currEntry);
            if (queue.size() == k) {
                var entry = queue.poll();
                if (entry.getValue() > 0) {
                    maxHeap.add(entry);
                }
            }
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }
}
