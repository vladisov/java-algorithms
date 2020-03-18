package dev.algos.snatch.data_structures.graph;

import dev.algos.snatch.data_structures.graph.util.GraphNode;

public interface WeightedGraph<T> extends Graph<T> {

    void addEdge(GraphNode<T> a, GraphNode<T> b, int weight);
}
