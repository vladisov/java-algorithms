package dev.algos.snatch.data_structures.graph.algorithms;

import dev.algos.snatch.data_structures.graph.WeightedGraph;
import dev.algos.snatch.data_structures.graph.WeightedGraphAdjacencyList;
import dev.algos.snatch.data_structures.graph.WeightedGraphAdjacencyList.Edge;
import dev.algos.snatch.data_structures.graph.util.GraphNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSpanningTreeTest {

    @Test
    void test() {
        MinimumSpanningTree mst = new MinimumSpanningTree();

        GraphNode<Integer> n0 = new GraphNode<>(0);
        GraphNode<Integer> n1 = new GraphNode<>(1);
        GraphNode<Integer> n2 = new GraphNode<>(2);
        GraphNode<Integer> n3 = new GraphNode<>(3);
        GraphNode<Integer> n4 = new GraphNode<>(4);
        GraphNode<Integer> n5 = new GraphNode<>(5);

        WeightedGraph<Integer> graph = new WeightedGraphAdjacencyList<>(List.of(n0, n1, n2, n3, n4, n5), true);

        graph.addEdge(n2, n3, 10);
        graph.addEdge(n3, n1, 5);
        graph.addEdge(n4, n0, 17);
        graph.addEdge(n4, n1, 12);
        graph.addEdge(n5, n2, 4);
        graph.addEdge(n5, n4, 25);

        List<Edge<Integer>> spanningTree = mst.findKruskalsMinimumSpanningTree(graph);
        assertEquals("[[5, 2, 4], [3, 1, 5], [2, 3, 10], [4, 1, 12], [4, 0, 17]]", spanningTree.toString());
    }
}
