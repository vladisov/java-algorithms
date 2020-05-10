package dev.algos.snatch.interview_problems.top_k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.
 * <p>
 * Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose the (worker, bike) pair with the shortest Manhattan distance between each other, and assign the bike to that worker. (If there are multiple (worker, bike) pairs with the same shortest Manhattan distance, we choose the pair with the smallest worker index; if there are multiple ways to do that, we choose the pair with the smallest bike index). We repeat this process until there are no available workers.
 * <p>
 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
 * <p>
 * Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.
 * <p>
 * Example 1:
 * Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
 * Output: [1,0]
 * Explanation:
 * Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].
 */
public class CampusBikes {

    /**
     * Time O(N*MlogNM);
     * Space O(N*M)
     */
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> {
            if (a.distance == b.distance) {
                if (a.worker == b.worker) {
                    return a.bike - b.bike;
                }
                return a.worker - b.worker;
            }
            return a.distance - b.distance;
        });
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) +
                        Math.abs(workers[i][1] - bikes[j][1]);
                queue.add(new Pair(i, j, distance));
            }
        }
        boolean[] assigned = new boolean[bikes.length];
        int[] result = new int[workers.length];
        Arrays.fill(result, -1);
        while (!queue.isEmpty()) {
            var pair = queue.poll();
            if (result[pair.worker] != -1 || assigned[pair.bike]) continue;
            result[pair.worker] = pair.bike;
            assigned[pair.bike] = true;
        }
        return result;
    }

    public int[] assignBikesBucketSort(int[][] workers, int[][] bikes) {
        List<Pair> pairs = new ArrayList<>();
        List[] buckets = new List[2001];
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
                Pair pair = new Pair(i, j, distance);
                pairs.add(pair);
                if (buckets[pair.distance] == null) {
                    buckets[pair.distance] = new LinkedList<Pair>();
                }
                buckets[pair.distance].add(pair);
            }
        }
        boolean[] assigned = new boolean[bikes.length];
        int[] result = new int[workers.length];
        Arrays.fill(result, -1);
        for (List<Pair> bucket : buckets) {
            if (bucket != null) {
                for (Pair pair : bucket) {
                    if (result[pair.worker] != -1 || assigned[pair.bike]) continue;
                    result[pair.worker] = pair.bike;
                    assigned[pair.bike] = true;
                }
            }
        }
        return result;
    }

    static class Pair {
        int worker;
        int bike;
        int distance;

        public Pair(int worker, int bike, int distance) {
            this.worker = worker;
            this.bike = bike;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return worker + " " + bike + " " + distance;
        }
    }
}
