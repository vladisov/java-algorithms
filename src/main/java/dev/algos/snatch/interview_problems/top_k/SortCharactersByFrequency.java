package dev.algos.snatch.interview_problems.top_k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {

    /**
     * Time O(n log m) where m is number of distinct characters (might be the same as n)
     * Space O(n)
     */
    public String frequencySort(String s) {
        if (s == null) return s;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    /**
     * Time O(n)
     * Space O(n)
     */
    public String frequencySortBuckets(String s) {
        if (s == null || s.length() == 0) return s;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List[] lists = new List[s.length() + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (lists[freq] == null) {
                lists[freq] = new ArrayList();
            }
            lists[freq].add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = lists.length - 1; i >= 0; i--) {
            List<Character> chars = lists[i];
            for (char c : chars) {
                for (int j = 0; j < i; j++) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
