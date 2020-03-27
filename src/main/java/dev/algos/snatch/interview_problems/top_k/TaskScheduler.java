package dev.algos.snatch.interview_problems.top_k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

    /**
     * Time complexity O(NlogN)
     * Space complexity O(N)
     */
    public int leastInterval(char[] tasks, int k) {
        if (tasks.length == 0) return 0;
        Map<Character, Integer> frequency = new HashMap<>(); // char to index
        for (char c : tasks) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        maxHeap.addAll(frequency.entrySet());
        int counter = 0;
        while (!maxHeap.isEmpty()) {
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            int n = k + 1;
            for (; n > 0 && !maxHeap.isEmpty(); n--) {
                var currEntry = maxHeap.poll();
                currEntry.setValue(currEntry.getValue() - 1);
                if (currEntry.getValue() > 0) {
                    waitList.add(currEntry);
                }
                counter++;
            }
            maxHeap.addAll(waitList);
            if (!maxHeap.isEmpty()) {
                counter += n;
            }
        }

        return counter;
    }
}
