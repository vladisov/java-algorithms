package dev.algos.snatch.data_structures.graph;

import dev.algos.snatch.data_structures.graph.algorithms.Dijkstra;
import dev.algos.snatch.data_structures.graph.util.GraphNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DijkstraTest {

    Dijkstra instance = new Dijkstra();

    /*
          Graph

            B
       10       15
    A       5       D
       20       20
            C
     */
    @Test
    void testAdjacencyMatrix() {
        var a = new GraphNode<>("A");
        var b = new GraphNode<>("B");
        var c = new GraphNode<>("C");
        var d = new GraphNode<>("D");
        var graph = new GraphAdjacencyMatrix<String>(new GraphNode[]{a, b, c, d});
        graph.addEdge(a, b, 10);
        graph.addEdge(a, c, 20);
        graph.addEdge(b, c, 5);
        graph.addEdge(b, d, 15);
        graph.addEdge(c, d, 20);
        assertThat(instance.findShortestPath(graph, a), equalTo("[[A, 0][B, 10][C, 15][D, 25]]"));
        assertThat(instance.findShortestPath(graph, c), equalTo("[[C, 0][A, 15][B, 5][D, 20]]"));
    }

    @Test
    void testAdjacencyList() {
        var a = new GraphNode<>("A");
        var b = new GraphNode<>("B");
        var c = new GraphNode<>("C");
        var d = new GraphNode<>("D");
        var graph = new WeightedGraphAdjacencyList<>(List.of(a, b, c, d));
        graph.addEdge(a, b, 10);
        graph.addEdge(a, c, 20);
        graph.addEdge(b, c, 5);
        graph.addEdge(b, d, 15);
        graph.addEdge(c, d, 20);
        assertThat(instance.findShortestPath(graph, a), equalTo("[[A, 0][B, 10][C, 15][D, 25]]"));
        assertThat(instance.findShortestPath(graph, c), equalTo("[[C, 0][A, 15][B, 5][D, 20]]"));
    }
}
