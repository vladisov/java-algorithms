package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return solve(graph, 0);
    }

    private List<List<Integer>> solve(int[][] graph, int node) {
        List<List<Integer>> result = new ArrayList<>();
        if (node == graph.length - 1) {
            List<Integer> path = new ArrayList<>();
            path.get(graph.length - 1);
            result.add(path);
            return result;
        }

        int[] neighbors = graph[node];
        for (int nei : neighbors) {
            for (List<Integer> path : solve(graph, nei)) {
                path.add(0, node);
                result.add(path);
            }
        }
        return result;
    }
}
