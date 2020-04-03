package dev.algos.snatch.interview_problems.dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
 * <p>
 * Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
 * <p>
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 */
public class MinimumFlightsWithKStops {

    /**
     * Time O()
     * Space O(V + E)
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n == 0) {
            return -1;
        }
        List<Edge>[] graph = new List[n];
        for (int[] flight : flights) {
            int source = flight[0];
            Edge edge = new Edge(source, flight[1], flight[2]);
            if (graph[source] == null) {
                graph[source] = new ArrayList<>();
            }
            graph[source].add(edge);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.add(new int[]{src, 0, 0});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int node = info[0];
            int step = info[1];
            int weight = info[2];
            if (node == dst) {
                return weight;
            }
            if (graph[node] != null) {
                for (Edge edge : graph[node]) {
                    int nei = edge.dst;
                    if (step == K && nei != dst) {
                        continue;
                    }
                    int dstWeight = weight + edge.weight;
                    queue.add(new int[]{nei, step + 1, dstWeight});
                }
            }
        }
        return -1;
    }

    static class Edge {
        public int src;
        public int dst;
        public int weight;

        public Edge(int src, int dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }
    }
}
