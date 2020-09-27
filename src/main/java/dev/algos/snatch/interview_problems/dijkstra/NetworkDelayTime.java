package dev.algos.snatch.interview_problems.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are N network nodes, labelled 1 to N.
 * <p>
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.
 * <p>
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 */
public class NetworkDelayTime {

    /**
     * Basically, the time complexity is O(ElogV) since we may add each vertex into the pq (logV) and we do this for each of its neighbours (at most E times).
     * <p>
     * Time O(ElogV)
     * Space O(V + E)
     */
    int findSum(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        Map<Integer, Integer> dist = new HashMap<>();

        dist.put(k, 0);
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[]{k, 0});
        while (!queue.isEmpty()) {
            int[] src = queue.poll();
            int currWeight = src[1];
            List<int[]> neighbors = graph.get(src[0]);
            if (neighbors != null) {
                for (int[] nei : neighbors) {
                    int dst = nei[0];
                    int weight = nei[1];
                    int total = currWeight + weight;
                    if (dist.get(dst) == null ||
                            dist.get(dst) > total) {
                        dist.put(dst, total);
                        queue.add(new int[]{dst, total});
                    }
                }
            }
        }
        if (dist.size() < n) return -1;
        int max = 0;
        for (int val : dist.values()) {
            max = Math.max(val, max);
        }
        return max;
    }
}
