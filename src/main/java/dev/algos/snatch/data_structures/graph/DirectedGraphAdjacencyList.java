package dev.algos.snatch.data_structures.graph;

import java.util.ArrayList;
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
public class DirectedGraphAdjacencyList<T> {

    List<GraphNode<T>> graphNodes;

    public DirectedGraphAdjacencyList() {
        graphNodes = new ArrayList<>();
    }

    public DirectedGraphAdjacencyList(List<GraphNode<T>> graphNodes) {
        this.graphNodes = graphNodes;
    }

    boolean isConnected(T first, T second) {
        var firstNode = findNode(first);
        var secondNode = findNode(second);
        return firstNode.neighbors.contains(secondNode);
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
            values.add(node.val);
            boolean added = false;
            for (var neighbor : node.neighbors) {
                if (neighbor.equals(secondNode)) {
                    values.add(neighbor.val);
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

    boolean addEdge(T first, T second) {
        var firstNode = findNode(first);
        var secondNode = findNode(second);
        if (!firstNode.neighbors.contains(secondNode)) {
            firstNode.neighbors.add(secondNode);
            return true;
        }
        return false;
    }

    public List<GraphNode<T>> getGraphNodes() {
        return graphNodes;
    }

    private GraphNode<T> findNode(T value) {
        for (GraphNode<T> graphNode : graphNodes) {
            if (graphNode.val == value) {
                return graphNode;
            }
        }
        throw new NoSuchElementException(value.toString());
    }

    public static class GraphNode<T> {
        T val;
        List<GraphNode<T>> neighbors;

        public GraphNode(T val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public List<GraphNode<T>> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(List<GraphNode<T>> neighbors) {
            this.neighbors = neighbors;
        }
    }
}
