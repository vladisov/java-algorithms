package dev.algos.snatch.interview_problems.graph;

import dev.algos.snatch.data_structures.graph.GraphAdjacencyList;
import dev.algos.snatch.data_structures.graph.algorithms.TopologicalSort;
import dev.algos.snatch.data_structures.graph.util.GraphNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class TopologicalSortTest {
    GraphAdjacencyList<Integer> graph;
    TopologicalSort topologicalSort = new TopologicalSort();

    @BeforeEach
    void setUp() {
        GraphNode<Integer> n0 = new GraphNode<>(0);
        GraphNode<Integer> n1 = new GraphNode<>(1);
        GraphNode<Integer> n2 = new GraphNode<>(2);
        GraphNode<Integer> n3 = new GraphNode<>(3);
        GraphNode<Integer> n4 = new GraphNode<>(4);
        GraphNode<Integer> n5 = new GraphNode<>(5);

        n0.setNeighbors(List.of());
        n1.setNeighbors(List.of());
        n2.setNeighbors(List.of(n3));
        n3.setNeighbors(List.of(n1));
        n4.setNeighbors(List.of(n0, n1));
        n5.setNeighbors(List.of(n2, n4));
        graph = new GraphAdjacencyList<>(List.of(n0, n1, n2, n3, n4, n5));
    }

    @Test
    void testTopologicalSortRecursive() {
        String result = topologicalSort.topologicalSortRecursive(graph);
        assertThat(result, equalTo("[5, 4, 2, 3, 1, 0]"));
    }

    @Test
    void testTopologicalSortKhan() {
        String result = topologicalSort.topologicalSortKhan(graph);
        assertThat(result, equalTo("[5, 2, 4, 3, 0, 1]"));
    }

    @Test
    void testTopologicalSortAll() {
        List<String> result = topologicalSort.allTopologicalSorts(graph);
        assertThat(result.toString(),
                equalTo(
                        "[[5, 2, 3, 1, 4, 0], [5, 2, 3, 4, 0, 1], " +
                                "[5, 2, 3, 4, 1, 0], [5, 2, 4, 0, 3, 1], [5, 2, 4, 3, 0, 1], " +
                                "[5, 2, 4, 3, 1, 0], [5, 4, 0, 2, 3, 1], [5, 4, 2, 0, 3, 1], " +
                                "[5, 4, 2, 3, 0, 1], [5, 4, 2, 3, 1, 0]]"));
    }
}
