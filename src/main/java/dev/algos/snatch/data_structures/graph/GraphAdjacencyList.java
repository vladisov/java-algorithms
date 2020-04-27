package dev.algos.snatch.data_structures.graph;

import dev.algos.snatch.data_structures.graph.util.GraphNode;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;

/**
 * Adjacency List Representation
 * Directed graph
 * <p>
 * 1 -> 2
 * 2 -> 4 -> 5
 * 3 -> 2
 * 4
 * 5
 */
public class GraphAdjacencyList<T> implements Graph<T> {

    private final List<GraphNode<T>> graphNodes;
    private final boolean directed;

//    public GraphAdjacencyList() {
//        graphNodes = new ArrayList<>();
//    }

    public GraphAdjacencyList(List<GraphNode<T>> graphNodes, boolean directed) {
        this.graphNodes = graphNodes;
        this.directed = directed;
    }

    public GraphAdjacencyList(List<GraphNode<T>> graphNodes) {
        this.graphNodes = graphNodes;
        this.directed = false;
    }

    boolean isConnected(T first, T second) {
        var firstNode = findNode(first);
        var secondNode = findNode(second);
        return firstNode.getNeighbors().contains(secondNode);
    }

    String getPath(T first, T second) {
        //dfs
        var firstNode = findNode(first);
        var secondNode = findNode(second);
        Stack<GraphNode<T>> stack = new Stack<>();
        Set<GraphNode<T>> visited = new HashSet<>();
        Stack<T> values = new Stack<>();
        stack.add(firstNode);
        while (!stack.isEmpty()) {
            var node = stack.pop();
            values.add(node.getVal());
            boolean added = false;
            for (var neighbor : node.getNeighbors()) {
                if (neighbor.equals(secondNode)) {
                    values.add(neighbor.getVal());
                    return values.toString();
                }
                if (!visited.contains(neighbor)) {
                    added = true;
                    stack.add(neighbor);
                    visited.add(neighbor);
                }
            }
            if (!added) {
                values.pop();
            }
        }
        return "[]";
    }

    @Override
    public void addEdge(GraphNode<T> a, GraphNode<T> b) {
        if (!a.getNeighbors().contains(b)) {
            a.getNeighbors().add(b);
        }
        if (!directed && !b.getNeighbors().contains(a)) {
            b.getNeighbors().add(a);
        }
    }

    @Override
    public void removeEdge(GraphNode<T> a, GraphNode<T> b) {
        a.getNeighbors().remove(b);
        b.getNeighbors().remove(a);
    }

    @Override
    public List<WeightedGraphAdjacencyList.Edge<T>> getAllEdges() {
        return List.of(); //TODO
    }

    @Override
    public String edgesToString() {
        StringBuilder edges = new StringBuilder();
        edges.append("[");
        for (GraphNode<T> node : graphNodes) {
            for (GraphNode<T> nei : node.getNeighbors()) {
                edges.append("[" + node.getVal() + "," + nei.getVal() + "]");
            }
        }
        return edges.append("]").toString();
    }

    @Override
    public int size() {
        return graphNodes.size();
    }

    public List<GraphNode<T>> getGraphNodes() {
        return graphNodes;
    }

    private GraphNode<T> findNode(T value) {
        for (GraphNode<T> graphNode : graphNodes) {
            if (graphNode.getVal() == value) {
                return graphNode;
            }
        }
        throw new NoSuchElementException(value.toString());
    }

}
