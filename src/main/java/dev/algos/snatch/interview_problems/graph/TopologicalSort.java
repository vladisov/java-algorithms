package dev.algos.snatch.interview_problems.graph;

import dev.algos.snatch.data_structures.graph.DirectedGraphAdjacencyList;
import dev.algos.snatch.data_structures.graph.DirectedGraphAdjacencyList.GraphNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * topological sort or topological ordering of a directed graph is a linear ordering of its vertices such that for every directed edge
 * uv from vertex u to vertex v, u comes before v in the ordering.
 */
public class TopologicalSort {

    <T> String topologicalSortRecursive(DirectedGraphAdjacencyList<T> graph) {
        Set<GraphNode<T>> visited = new HashSet<>();
        Stack<T> values = new Stack<>();
        for (GraphNode<T> graphNode : graph.getGraphNodes()) {
            if (!visited.contains(graphNode))
                topologicalSortRecursiveUtil(graphNode, visited, values);
        }
        String result = "";
        while (!values.isEmpty()) {
            result += values.pop() + " ";
        }
        return result.trim();
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

}
