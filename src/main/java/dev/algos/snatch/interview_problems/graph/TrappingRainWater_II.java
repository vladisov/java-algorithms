package dev.algos.snatch.interview_problems.graph;

import java.util.PriorityQueue;

public class TrappingRainWater_II {

    /**
     * Time O(N*Mlog(NM))
     * Space O(N*M)
     */
    public int trapRainWater(int[][] height) {
        int n = height.length, m = height[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> (a.height - b.height));
        for (int i = 0; i < n; i++) {
            visited[i][m - 1] = true;
            visited[i][0] = true;
            minHeap.add(new Cell(i, m - 1, height[i][m - 1]));
            minHeap.add(new Cell(i, 0, height[i][0]));
        }
        for (int i = 1; i < m - 1; i++) {
            visited[0][i] = true;
            visited[n - 1][i] = true;
            minHeap.add(new Cell(0, i, height[0][i]));
            minHeap.add(new Cell(n - 1, i, height[n - 1][i]));
        }
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int total = 0;
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            for (int[] dir : dirs) {
                int r = dir[0] + cell.row;
                int c = dir[1] + cell.row;
                if (isValid(r, c, n, m, visited)) {
                    visited[r][c] = true;
                    int h = height[r][c];
                    if (h < cell.height) {
                        total += cell.height - h;
                        h = cell.height;
                    }
                    minHeap.add(new Cell(r, c, h));
                }
            }
        }
        return total;
    }

    private boolean isValid(int r, int c, int n, int m, boolean[][] visited) {
        return r >= 0 && c >= 0 && r < n && c < m && !visited[r][c];
    }

    static class Cell {
        int row;
        int col;
        int height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
