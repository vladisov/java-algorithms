package dev.algos.snatch.data_structures.graph;

import dev.algos.snatch.data_structures.graph.util.GraphNode;

import java.util.List;

public class WeightedGraphAdjacencyList<T> implements WeightedGraph<T> {
    List<GraphNode<T>> graphNodes;

    public WeightedGraphAdjacencyList(List<GraphNode<T>> graphNodes) {
        this.graphNodes = graphNodes;
    }

    @Override
    public void addEdge(GraphNode<T> a, GraphNode<T> b, boolean directed) {

    }

    @Override
    public void removeEdge(GraphNode<T> a, GraphNode<T> b) {

    }

    @Override
    public String getAllEdges() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    public List<GraphNode<T>> getGraphNodes() {
        return graphNodes;
    }

    @Override
    public void addEdge(GraphNode<T> a, GraphNode<T> b, boolean directed, int weight) {

    }
}
