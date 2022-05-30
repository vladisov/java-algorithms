package dev.algos.snatch.interview_problems.topological_sort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/alien-dictionary/
 */
public class AlienDictionary {

    /**
     * Time O(C + E?) - all characters
     * Space O(C)
     */
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.putIfAbsent(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            int len = Math.min(curr.length(), next.length());
            for (int j = 0; j < len; j++) {
                if (curr.charAt(j) != next.charAt(j)) {
                    map.putIfAbsent(curr.charAt(j), new ArrayList<>());
                    map.putIfAbsent(next.charAt(j), new ArrayList<>());
                    map.get(curr.charAt(j)).add(next.charAt(j));
                    indegree.put(next.charAt(j), indegree.get(next.charAt(j)) + 1);
                    break;
                }
                if (j == len - 1 && curr.length() > next.length()) return "";
            }
        }

        Queue<Character> queue = new ArrayDeque<>();
        for (var entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            if (map.containsKey(c)) {
                for (var child : map.get(c)) {
                    indegree.put(child, indegree.getOrDefault(child, 0) - 1);
                    if (indegree.get(child) == 0) {
                        queue.add(child);
                    }
                }
            }


        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}
