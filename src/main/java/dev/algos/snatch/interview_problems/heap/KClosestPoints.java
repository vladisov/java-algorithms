package dev.algos.snatch.interview_problems.heap;

import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 */
public class KClosestPoints {

    public int[][] kClosest(int[][] points, int K) {
        if (points.length == 0) return new int[][]{};
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> distanceSqrt(points[b]) - distanceSqrt(points[a]));
        for (int i = 0; i < points.length; i++) {
            queue.add(i);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = points[queue.poll()];
        }
        return result;
    }

    private int distanceSqrt(int[] arr) {
        return arr[0] * arr[0] + arr[1] * arr[1];
    }
}
