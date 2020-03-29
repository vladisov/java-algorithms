package dev.algos.snatch.interview_problems.top_k;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

    /**
     * Time complexity O(N*logD) d - number of distinct = NlogN
     * Space O(N)
     */
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) return s;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        queue.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            var entry = queue.poll();
            char c = entry.getKey();
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                if (queue.isEmpty()) {
                    return "";
                } else {
                    var tmp = entry;
                    entry = queue.poll();
                    c = entry.getKey();
                    queue.add(tmp);
                }
            }
            sb.append(c);
            int freq = entry.getValue() - 1;
            if (freq != 0) {
                entry.setValue(freq);
                queue.add(entry);
            }
        }
        return sb.toString();
    }

    public String rearrangeString(String str) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray())
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        // add all characters to the max heap
        maxHeap.addAll(charFrequencyMap.entrySet());

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder resultString = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            // add the previous entry back in the heap if its frequency is greater than zero
            if (previousEntry != null && previousEntry.getValue() > 0)
                maxHeap.offer(previousEntry);
            // append the current character to the result string and decrement its count
            resultString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }

        // if we were successful in appending all the characters to the result string, return it
        return resultString.length() == str.length() ? resultString.toString() : "";
    }
}
