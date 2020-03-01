package dev.algos.snatch.data_structures.graph;

import dev.algos.snatch.data_structures.graph.util.GraphNode;

import java.util.List;

public class WeightedGraphAdjacencyList<T> {
    List<GraphNode<T>> graphNodes;

    public WeightedGraphAdjacencyList(List<GraphNode<T>> graphNodes) {
        this.graphNodes = graphNodes;
    }

    public List<GraphNode<T>> getGraphNodes() {
        return graphNodes;
    }
}
