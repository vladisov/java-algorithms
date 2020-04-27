package dev.algos.snatch.data_structures.graph;

import dev.algos.snatch.data_structures.graph.util.GraphNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class GraphAdjacencyMatrixTest {

    private GraphAdjacencyMatrix<Integer> graph;

    @Test
    void test() {
        GraphNode<Integer> n0 = new GraphNode<>(0);
        GraphNode<Integer> n1 = new GraphNode<>(1);
        GraphNode<Integer> n2 = new GraphNode<>(2);
        GraphNode<Integer> n3 = new GraphNode<>(3);
        GraphNode<Integer> n4 = new GraphNode<>(4);

        graph = new GraphAdjacencyMatrix<>(new GraphNode[]{n0, n1, n2, n3, n4});

        assertThat(graph.edgesToString(), equalTo("[]"));

        graph.addEdge(n1, n4);
        graph.addEdge(n1, n3);

        assertThat(graph.edgesToString(), equalTo("[[1, 3], [1, 4], [3, 1], [4, 1]]"));

    }
}
