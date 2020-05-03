package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BipartiteGraph {

    /**
     * TC O(V + E)
     * Space O(V)
     */
    public boolean isBipartiteBFS(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for (int i = 0; i < len; i++) {
            if (colors[i] != 0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            colors[i] = 1; // 1 - red, -1 - black
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int nei : graph[curr]) {
                    if (colors[nei] == 0) {
                        colors[nei] = -colors[curr];
                        queue.add(nei);
                    } else if (colors[nei] != -colors[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * My bruteforce BFS solution
     */
    public boolean isBipartite(int[][] graph) {
        if (graph.length == 0) return false;
        List<Set<Integer>> sets = new ArrayList<>();
        sets.add(new HashSet<>());
        sets.add(new HashSet<>());
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> curr = sets.get(0);
        Set<Integer> next = sets.get(1);
        Set<Integer> visited = new HashSet<>();
        curr.add(0);
        queue.add(0);
        int index = 0;
        while (!queue.isEmpty() || index < graph.length) {
            if (queue.isEmpty()) {
                if (!visited.contains(index)) {
                    queue.add(index);
                }
                index++;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                visited.add(node);
                for (int nei : graph[node]) {
                    if (curr.contains(nei)) return false;
                    next.add(nei);
                    if (!visited.contains(nei)) {
                        queue.add(nei);
                    }
                }
            }

            Set<Integer> tmp = curr;
            curr = next;
            next = tmp;
        }
        return true;
    }
}
