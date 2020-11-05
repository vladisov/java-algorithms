package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).
 * The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.
 * Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.
 * A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.
 * Example 1:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
 * Output: [2,1,1,1,1,1,1]
 * Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a' as well, thus the answer is 2. Notice that any node is part of its sub-tree.
 * Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have different labels than node 1, the answer is just 1 (the node itself).
 */
public class NumberOfNodesInSubtreeWithTheSameLabel {

    /**
     * Time O(N*26)
     * Space O(N)
     */
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Node[] graph = new Node[n];

        for (int[] edge : edges) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new Node(labels.charAt(edge[0]), edge[0]);
            }
            if (graph[edge[1]] == null) {
                graph[edge[1]] = new Node(labels.charAt(edge[1]), edge[1]);
            }
            graph[edge[0]].children.add(graph[edge[1]]);
            graph[edge[1]].children.add(graph[edge[0]]);
        }
        dfs(graph[0], new boolean[n]);

        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = graph[i].chars[graph[i].label - 'a'];
        }

        return count;
    }

    void dfs(Node node, boolean[] visited) {
        if (visited[node.index]) return;
        node.chars[node.label - 'a'] = 1;
        visited[node.index] = true;
        for (var child : node.children) {
            if (!visited[child.index]) {
                dfs(child, visited);
                for (int i = 0; i < 26; i++) {
                    node.chars[i] += child.chars[i];
                }
            }

        }
    }

    static class Node {
        int index;
        int[] chars;
        char label;
        List<Node> children;

        public Node(char label, int index) {
            this.label = label;
            this.chars = new int[26];
            this.children = new ArrayList<>();
            this.index = index;
        }
    }
}
