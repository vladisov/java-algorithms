package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder_II {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList.isEmpty()) return List.of();
        List<List<String>> result = new ArrayList<>();

        Set<String> dict = new HashSet<>(wordList);
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, dict, graph, distance);
        dfs(beginWord, endWord, graph, distance, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String current, String endWord, Map<String, List<String>> graph,
                     Map<String, Integer> distance, List<String> path, List<List<String>> result) {
        path.add(current);
        if (endWord.equals(current)) {
            result.add(new ArrayList<>(path));
        } else {
            List<String> neighbors = graph.get(current);
            for (String nei : neighbors) {
                if (distance.get(nei) == distance.get(current) + 1) {
                    dfs(nei, endWord, graph, distance, path, result);
                }
            }
        }
        path.remove(path.size() - 1);
    }

    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> graph, Map<String, Integer> distance) {
        for (String str : dict) {
            graph.put(str, new ArrayList<>());
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        graph.put(beginWord, new ArrayList<>());
        distance.put(beginWord, 0);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            List<String> neighbors = getNeighbors(word, dict);
            boolean found = false;
            for (String neighbor : neighbors) {
                graph.get(word).add(neighbor);
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(word) + 1);
                    if (neighbor.equals(endWord)) {
                        found = true;
                    } else {
                        queue.add(neighbor);
                    }
                }
                if (found) {
                    break;
                }
            }
        }
    }

    private List<String> getNeighbors(String word, Set<String> dict) {
        List<String> words = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char old = chars[i];
                chars[i] = c;
                if (old == c) continue;
                String newWord = new String(chars);
                if (dict.contains(newWord)) {
                    words.add(newWord);
                }
                chars[i] = old;
            }
        }
        return words;
    }
}
