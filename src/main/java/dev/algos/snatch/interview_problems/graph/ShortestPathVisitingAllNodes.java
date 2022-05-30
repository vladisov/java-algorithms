package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes
 */
public class ShortestPathVisitingAllNodes {

    /**
     * Time
     * N - nodes, total number of states - 2^N
     * for each state we check N nodes, thus
     * 2^N * N
     * Space 2^N * N
     */
    public int shortestPathLength(int[][] graph) {
        Queue<State> queue = new ArrayDeque<>();
        Set<State> set = new HashSet<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            int mask = (1 << i);
            set.add(new State(mask, i));
            queue.add(new State(mask, i, 1));
        }
        while (!queue.isEmpty()) {
            State node = queue.poll();
            if (node.mask == (1 << n) - 1) {
                return node.cost - 1;
            }
            for (int adj : graph[node.curr]) {
                int mask = node.mask | (1 << adj);
                State path = new State(mask, adj);
                if (!set.contains(path)) {
                    set.add(path);
                    queue.add(new State(mask, adj, node.cost + 1));
                }
            }
        }

        return -1;
    }

    static class State {
        int mask;
        int curr;
        int cost;

        public State(int mask, int curr, int cost) {
            this.mask = mask;
            this.curr = curr;
            this.cost = cost;
        }

        public State(int mask, int curr) {
            this.mask = mask;
            this.curr = curr;
            this.cost = 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return mask == state.mask &&
                    curr == state.curr &&
                    cost == state.cost;
        }

        @Override
        public int hashCode() {
            return Objects.hash(mask, curr, cost);
        }
    }
}
