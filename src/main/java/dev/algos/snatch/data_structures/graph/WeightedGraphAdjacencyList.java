package dev.algos.snatch.data_structures.graph;

import dev.algos.snatch.data_structures.graph.util.GraphNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeightedGraphAdjacencyList<T> implements WeightedGraph<T> {
    private final List<GraphNode<T>> graphNodes;
    private final List<Edge<T>> edges;
    private final boolean directed;

    public WeightedGraphAdjacencyList(List<GraphNode<T>> graphNodes, List<Edge<T>> edges, boolean directed) {
        this.graphNodes = graphNodes;
        this.edges = edges;
        this.directed = directed;
    }

    public WeightedGraphAdjacencyList(List<GraphNode<T>> graphNodes, boolean directed) {
        this.graphNodes = graphNodes;
        this.edges = new ArrayList<>();
        this.directed = directed;
    }

    public WeightedGraphAdjacencyList(List<GraphNode<T>> graphNodes) {
        this.graphNodes = graphNodes;
        this.edges = new ArrayList<>();
        this.directed = false;
    }

    @Override
    public void addEdge(GraphNode<T> a, GraphNode<T> b) {
        this.addEdge(a, b, 0);
    }

    @Override
    public void addEdge(GraphNode<T> a, GraphNode<T> b, int weight) {
        connectNodes(a, b, weight);
        if (!this.directed) {
            connectNodes(b, a, weight);
        }
    }

    private void connectNodes(GraphNode<T> a, GraphNode<T> b, int weight) {
        var neighbors = a.getNeighbors();
        if (!neighbors.contains(b)) {
            neighbors.add(b);
            edges.add(new Edge<>(weight, a, b));
        }
    }

    @Override
    public void removeEdge(GraphNode<T> a, GraphNode<T> b) {
        var neighbors = a.getNeighbors();
        neighbors.remove(b);
        if (!directed) {
            b.getNeighbors().remove(a);
        }

        final Iterator<Edge<T>> edgeIterator = edges.iterator();
        while (edgeIterator.hasNext()) {
            Edge<T> edge = edgeIterator.next();
            if (edge.getSrc().equals(a) && edge.getDest().equals(b)) {
                edgeIterator.remove();
            }
            if (!directed && edge.getSrc().equals(b) && edge.getDest().equals(a)) {
                edgeIterator.remove();
            }
        }
    }

    @Override
    public String getAllEdges() {
        return this.edges.toString();
    }

    @Override
    public int size() {
        return graphNodes.size();
    }

    public List<GraphNode<T>> getGraphNodes() {
        return graphNodes;
    }

    static class Edge<T> {
        private int weight;
        private GraphNode<T> src;
        private GraphNode<T> dest;

        public Edge(int weight, GraphNode<T> src, GraphNode<T> dest) {
            this.weight = weight;
            this.src = src;
            this.dest = dest;
        }

        public int getWeight() {
            return weight;
        }

        public GraphNode<T> getSrc() {
            return src;
        }

        public GraphNode<T> getDest() {
            return dest;
        }

        @Override
        public String toString() {
            return String.format("[%s, %s, %d]", src.getVal().toString(), dest.getVal().toString(), weight);
        }
    }
}
