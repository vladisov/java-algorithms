package dev.algos.snatch.interview_problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 * <p>
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * <p>
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 * <p>
 * Input: A = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 * <p>
 * Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 */
public class ShortestBridge {

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * Time O(N*M)
     * Space O(N*M)
     */
    public int shortestBridge(int[][] A) {
        int n = A.length, m = A[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    markFirstIsland(A, i, j, visited, queue);
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        int lvl = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] node = queue.poll();
                for (int[] dir : dirs) {
                    int i = node[0] + dir[0];
                    int j = node[1] + dir[1];
                    if (i < 0 || j < 0 || i == n || j == m || visited[i][j]) continue;
                    if (A[i][j] == 1) return lvl;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
            lvl++;
        }
        return -1;
    }

    private void markFirstIsland(int[][] A, int i, int j, boolean[][] visited, Queue<int[]> queue) {
        if (i < 0 || j < 0 || i == A.length || j == A[i].length || A[i][j] == 0 || visited[i][j]) return;
        visited[i][j] = true;
        queue.add(new int[]{i, j});
        for (int[] dir : dirs) {
            markFirstIsland(A, i + dir[0], j + dir[1], visited, queue);
        }
    }
}
