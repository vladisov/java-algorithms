package dev.algos.snatch.data_structures.graph.algorithms;

import dev.algos.snatch.data_structures.graph.GraphAdjacencyMatrix;
import dev.algos.snatch.data_structures.graph.WeightedGraphAdjacencyList;
import dev.algos.snatch.data_structures.graph.util.GraphNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {

    <T> String findShortestPath(WeightedGraphAdjacencyList<T> graph, GraphNode<T> root) {
        String result = "";

        return result;
    }

    <T> String findShortestPath(GraphAdjacencyMatrix<T> graph, GraphNode<T> root) {
        PriorityQueue<NodeWeight<T>> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.calculatedWeight));
        queue.add(new NodeWeight<>(root, 0));

        Map<GraphNode<T>, Integer> distance = new HashMap<>();
        distance.put(root, 0);

        Set<GraphNode<T>> settled = new HashSet<>();

        while (settled.size() < graph.size()) {
            NodeWeight<T> nodeWeight = queue.poll();
            GraphNode<T> node = nodeWeight.node;
            int currWeight = nodeWeight.calculatedWeight;

            settled.add(node);
            updateNeighbors(node, currWeight, distance, queue, settled);
        }
        return "";
    }

    private <T> void updateNeighbors(GraphNode<T> node, int currWeight, Map<GraphNode<T>, Integer> distance,
                                     PriorityQueue<NodeWeight<T>> queue, Set<GraphNode<T>> settled) {
        for (GraphNode<T> nei : node.getNeighbors()) {
            if (!settled.contains(nei)) {

                //
            }
        }
    }

    static class NodeWeight<T> {
        GraphNode<T> node;
        int calculatedWeight;

        public NodeWeight(GraphNode<T> node, int calculatedWeight) {
            this.node = node;
            this.calculatedWeight = calculatedWeight;
        }
    }
}
