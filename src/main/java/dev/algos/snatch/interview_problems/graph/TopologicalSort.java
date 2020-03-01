package dev.algos.snatch.interview_problems.graph;

import dev.algos.snatch.data_structures.graph.DirectedGraphAdjacencyList;
import dev.algos.snatch.data_structures.graph.DirectedGraphAdjacencyList.GraphNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * topological sort or topological ordering of a directed graph is a linear ordering of its vertices such that for every directed edge
 * uv from vertex u to vertex v, u comes before v in the ordering.
 */
public class TopologicalSort {

    /**
     * Time complexity O(V + E)
     * Space complexity O(V)
     */
    public <T> String topologicalSortRecursive(DirectedGraphAdjacencyList<T> graph) {
        Set<GraphNode<T>> visited = new HashSet<>();
        Stack<T> values = new Stack<>();
        for (GraphNode<T> graphNode : graph.getGraphNodes()) {
            if (!visited.contains(graphNode))
                topologicalSortRecursiveUtil(graphNode, visited, values);
        }

        List<T> valuesList = new ArrayList<>(values);
        Collections.reverse(valuesList);
        return valuesList.toString();
    }

    private <T> void topologicalSortRecursiveUtil(GraphNode<T> node, Set<GraphNode<T>> visited, Stack<T> values) {
        if (node == null) return;
        visited.add(node);
        for (GraphNode<T> nei : node.getNeighbors()) {
            if (!visited.contains(nei)) {
                topologicalSortRecursiveUtil(nei, visited, values);
            }
        }
        values.add(node.getVal());
    }

    public <T> String topologicalSortKhan(DirectedGraphAdjacencyList<T> graph) {
        Queue<GraphNode<T>> queue = new LinkedList<>();
        Map<GraphNode<T>, Integer> indegrees = new HashMap<>();
        List<T> values = new ArrayList<>();
        //count all indegrees
        for (var node : graph.getGraphNodes()) {
            for (var nei : node.getNeighbors()) {
                indegrees.put(nei, indegrees.getOrDefault(node, 0) + 1);
            }
        }
        //everything that doesnt have indegrees goes into queue
        for (var node : graph.getGraphNodes()) {
            if (!indegrees.containsKey(node)) {
                queue.add(node);
            }
        }
        //iterate through queue, decrement indegrees and if put 0 ones to queue
        int count = 0;
        int n = graph.getGraphNodes().size();
        while (!queue.isEmpty()) {
            var node = queue.poll();
            values.add(node.getVal());

            for (var nei : node.getNeighbors()) {
                indegrees.put(nei, indegrees.getOrDefault(nei, 1) - 1);

                if (indegrees.get(nei) == 0) {
                    queue.add(nei);
                }
            }
            count++;
        }

        if (count != n) {
            throw new RuntimeException("Graph has a cycle.");
        }

        return values.toString();
    }


    public <T> List<String> allTopologicalSorts(DirectedGraphAdjacencyList<T> graph) {
        List<String> result = new ArrayList<>();
        Map<GraphNode<T>, Integer> indegrees = new HashMap<>();
        Set<GraphNode<T>> visited = new HashSet<>();
        List<T> values = new ArrayList<>();
        //count all indegrees
        for (var node : graph.getGraphNodes()) {
            for (var nei : node.getNeighbors()) {
                indegrees.put(nei, indegrees.getOrDefault(node, 0) + 1);
            }
        }

        allTopologicalSortsUtil(graph, visited, indegrees, values, result);
        return result;
    }

    private <T> void allTopologicalSortsUtil(DirectedGraphAdjacencyList<T> graph, Set<GraphNode<T>> visited,
                                             Map<GraphNode<T>, Integer> indegrees, List<T> values, List<String> result) {
        int n = graph.getGraphNodes().size();
        // To indicate whether all topological are found or not
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            GraphNode<T> node = graph.getGraphNodes().get(i);
            if (!visited.contains(node) && indegrees.getOrDefault(node, 0) == 0) {
                visited.add(node);
                values.add(node.getVal());
                for (var nei : node.getNeighbors()) {
                    if (indegrees.getOrDefault(nei, 0) != 0)
                        indegrees.put(nei, indegrees.getOrDefault(nei, 1) - 1);
                }
                allTopologicalSortsUtil(graph, visited, indegrees, values, result);
                visited.remove(node);
                values.remove(values.size() - 1);
                for (var nei : node.getNeighbors()) {
                    indegrees.put(nei, indegrees.getOrDefault(nei, 0) + 1);
                }
                flag = true;
            }
        }
        if (!flag) {
            result.add(values.toString());
        }
    }
}
