package dev.algos.snatch.interview_problems.top_k;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> indexes = new HashMap<>(); // char to index
        Map<Character, Integer> frequency = new HashMap<>(); // char to index
        for (char c : tasks) {
            indexes.putIfAbsent(c, -n - 1);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        queue.addAll(indexes.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            var entry = queue.poll();
            var c = entry.getKey();
            var index = entry.getValue();
            int currIndex = sb.length();
            if (sb.length() != 0 && currIndex - n <= index) {
                sb.append("-");
                queue.add(entry);
            } else {
                sb.append(c);
                frequency.put(c, frequency.get(c) - 1);
                if (frequency.get(c) > 0) {
                    entry.setValue(currIndex);
                    queue.add(entry);
                }
            }
        }

        return sb.length();
    }
}
