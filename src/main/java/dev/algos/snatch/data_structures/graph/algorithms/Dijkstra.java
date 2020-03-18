package dev.algos.snatch.data_structures.graph.algorithms;

import dev.algos.snatch.data_structures.graph.GraphAdjacencyMatrix;
import dev.algos.snatch.data_structures.graph.WeightedGraphAdjacencyList;
import dev.algos.snatch.data_structures.graph.util.GraphNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {

    public <T> String findShortestPath(WeightedGraphAdjacencyList<T> graph, GraphNode<T> root) {
        Set<GraphNode<T>> visited = new HashSet<>();
        Map<GraphNode<T>, Integer> weights = new LinkedHashMap<>(); //weights so far
        Map<GraphNode<T>, GraphNode<T>> previous = new HashMap<>(); // previous node

        PriorityQueue<GraphNode<T>> queue = new PriorityQueue<>((a, b) -> weights.get(a) - weights.get(b));
        weights.put(root, 0);
        queue.add(root);


        while (!queue.isEmpty()) {
            GraphNode<T> source = queue.poll();
            int distanceSoFar = weights.get(source);
            var edges = graph.getEdges(source);
            for (var edge : edges) {
                GraphNode<T> destination = edge.getDest();
                int distance = distanceSoFar + edge.getWeight();
                if (weights.getOrDefault(destination, Integer.MAX_VALUE) > distance) {
                    weights.put(destination, distance);
                    previous.put(destination, source);
                }

                if (!visited.contains(destination)) {
                    visited.add(destination);
                    queue.add(destination);
                }
            }
            visited.add(source);
        }

        return toString(weights);
    }


    public <T> String findShortestPath(GraphAdjacencyMatrix<T> graph, GraphNode<T> root) {
        Set<GraphNode<T>> visited = new HashSet<>();
        Map<GraphNode<T>, Integer> weights = new LinkedHashMap<>(); //weights so far
        Map<GraphNode<T>, GraphNode<T>> previous = new HashMap<>(); // previous node

        PriorityQueue<GraphNode<T>> queue = new PriorityQueue<>((a, b) -> weights.get(a) - weights.get(b));
        weights.put(root, 0);
        queue.add(root);

        while (!queue.isEmpty()) {
            GraphNode<T> source = queue.poll();
            int distanceSoFar = weights.get(source);
            Map<GraphNode<T>, Integer> neighbors = graph.getNeighbors(source);
            for (Map.Entry<GraphNode<T>, Integer> destWeight : neighbors.entrySet()) {
                GraphNode<T> destination = destWeight.getKey();
                int distance = distanceSoFar + destWeight.getValue();
                if (weights.getOrDefault(destination, Integer.MAX_VALUE) > distance) {
                    weights.put(destination, distance);
                    previous.put(destination, source);
                }

                if (!visited.contains(destination)) {
                    visited.add(destination);
                    queue.add(destination);
                }
            }
            visited.add(source);
        }

        return toString(weights);
    }

    private <T> String toString(Map<GraphNode<T>, Integer> weights) {
        var sb = new StringBuilder()
                .append("[");
        weights.forEach((key, value) ->
                sb.append("[")
                        .append(key.getVal().toString())
                        .append(", ")
                        .append(value)
                        .append("]"));
        return sb.append("]").toString();
    }
}
