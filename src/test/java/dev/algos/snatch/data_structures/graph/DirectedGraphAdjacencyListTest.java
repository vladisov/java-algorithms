package dev.algos.snatch.data_structures.graph;

import dev.algos.snatch.data_structures.graph.DirectedGraphAdjacencyList.GraphNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class DirectedGraphAdjacencyListTest {

    @Test
    void getPathTest() {
        DirectedGraphAdjacencyList<Integer> graph = new DirectedGraphAdjacencyList<>();
        GraphNode<Integer> n1 = new GraphNode<>(1);
        GraphNode<Integer> n2 = new GraphNode<>(2);
        GraphNode<Integer> n3 = new GraphNode<>(3);
        GraphNode<Integer> n4 = new GraphNode<>(4);
        GraphNode<Integer> n5 = new GraphNode<>(5);

        n1.neighbors = List.of(n2, n3, n5);
        n2.neighbors = List.of(n1, n4);
        n3.neighbors = List.of(n1, n4, n5);
        n4.neighbors = List.of(n2, n3, n5);
        n5.neighbors = List.of(n1, n3, n4);

        graph.graphNodes.addAll(List.of(n1, n2, n3, n4, n5));

        String path = graph.getPath(1, 5);
        assertThat(path, equalTo("[1, 5]"));
        path = graph.getPath(1, 4);
        assertThat(path, equalTo("[1, 5, 4]"));
    }

}
