package dev.algos.snatch.data_structures.graph.algorithms;

import dev.algos.snatch.data_structures.graph.WeightedGraph;
import dev.algos.snatch.data_structures.graph.WeightedGraphAdjacencyList.Edge;
import dev.algos.snatch.data_structures.graph.util.GraphNode;
import dev.algos.snatch.data_structures.union_find.DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class MinimumSpanningTree {

    /**
     * Time O(ElogE + E) if we can say that disjoint set takes N operations in N time
     * Space O(E + V)
     */
    List<Edge<Integer>> findKruskalsMinimumSpanningTree(WeightedGraph<Integer> graph) {
        List<Edge<Integer>> allEdges = graph.getAllEdges();
        allEdges.sort((a, b) -> a.getWeight() - b.getWeight());
        DisjointSet disjointSet = new DisjointSet();
        graph.getGraphNodes().forEach(graphNode -> disjointSet.makeSet(graphNode.getVal())); //TODO should be get id

        List<Edge<Integer>> result = new ArrayList<>();
        for (Edge<Integer> edge : allEdges) {
            GraphNode<Integer> src = edge.getSrc();
            GraphNode<Integer> dst = edge.getDest();
            if (disjointSet.union(src.getVal(), dst.getVal())) {
                result.add(edge);
            }
        }
        return result;
    }
}
