package dev.algos.snatch.data_structures.graph.util;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {
    //todo make private
    public List<GraphNode<T>> neighbors;
    private T val;

    public GraphNode(T val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public T getVal() {
        return val;
    }

    public List<GraphNode<T>> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<GraphNode<T>> neighbors) {
        this.neighbors = neighbors;
    }
}
