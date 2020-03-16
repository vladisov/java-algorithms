package dev.algos.snatch.data_structures.graph;

import dev.algos.snatch.data_structures.graph.util.GraphNode;

import java.util.List;

public interface Graph<T> {

    void addEdge(GraphNode<T> a, GraphNode<T> b, boolean directed);

    void removeEdge(GraphNode<T> a, GraphNode<T> b);

    String getAllEdges();

    int size();

    List<GraphNode<T>> getGraphNodes();
}
