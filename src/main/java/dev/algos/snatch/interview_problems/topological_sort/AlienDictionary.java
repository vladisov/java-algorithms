package dev.algos.snatch.interview_problems.topological_sort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

    public String alienOrderKhan(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        StringBuilder result = new StringBuilder();
        if (words == null || words.length == 0) return result.toString();
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++) {
                char first = cur.charAt(j);
                char second = next.charAt(j);
                if (first != second) {
                    Set<Character> set = new HashSet<>();
                    map.putIfAbsent(first, set);
                    if (map.containsKey(first)) set = map.get(first);
                    if (!set.contains(second)) {
                        set.add(second);
                        map.put(first, set);
                        degree.put(second, degree.get(second) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) queue.add(c);
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result.append(c);
            if (map.containsKey(c)) {
                for (char nei : map.get(c)) {
                    degree.put(nei, degree.get(nei) - 1);
                    if (degree.get(nei) == 0) queue.add(nei);
                }
            }
        }
        if (result.length() != degree.size()) return "";
        return result.toString();
    }

}
