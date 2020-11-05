package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    /**
     * BFS
     * Time O(E + V)
     * Space O(V)
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        // map Node -> Node'
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (var adj : curr.neighbors) {
                if (!map.containsKey(adj)) {
                    queue.add(adj);
                    map.put(adj, new Node(adj.val));
                }
                map.get(curr).neighbors.add(map.get(adj));
            }
        }
        return map.get(node);
    }

    /**
     * DFS
     * Time O(E + V)
     * Space O(V)
     */
    public Node cloneGraphDFS(Node node) {
        // map Node -> Node'
        Map<Node, Node> map = new HashMap<>();

        return clone(node, map);
    }

    private Node clone(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node adj : node.neighbors) {
            newNode.neighbors.add(clone(adj, map));
        }
        return newNode;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
