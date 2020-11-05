package dev.algos.snatch.interview_problems.dijkstra;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinimumMovesToPushTheBox {

    int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public int minPushBox(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int boxI = -1, boxJ = -1, playerI = -1, playerJ = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'B') {
                    boxI = i;
                    boxJ = j;
                }
                if (grid[i][j] == 'S') {
                    playerI = i;
                    playerJ = j;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[n][m][n][m];
        for (int[] dir : dirs) {
            int x = boxI + dir[0];
            int y = boxJ + dir[1];
            if (x == n || y == m || x < 0 || y < 0 || !pathExists(playerI, playerJ, x, y, grid, new boolean[n][m], boxI, boxJ)
                    || grid[x][y] == '#' || grid[x][y] == 'T') continue;
            visited[boxI][boxJ][x][y] = true;
            queue.add(new int[]{x, y, boxI, boxJ});
        }

        int lvl = 0;
        while (!queue.isEmpty()) {
            lvl++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] info = queue.poll();
                int[] next = getNext(info);
                int nextBoxRow = next[0];
                int nextBoxCol = next[1];
                if (nextBoxRow == n || nextBoxCol == m || nextBoxRow < 0 || nextBoxCol < 0 || grid[nextBoxRow][nextBoxCol] == '#')
                    continue;
                if (grid[nextBoxRow][nextBoxCol] == 'T') return lvl;
                for (int[] dir : dirs) {
                    int x = nextBoxRow + dir[0];
                    int y = nextBoxCol + dir[1];
                    if (x == n || y == m || x < 0 || y < 0 || !pathExists(info[0], info[1], x, y, grid, new boolean[n][m], nextBoxRow, nextBoxCol)
                            || grid[x][y] == '#' || grid[x][y] == 'T') continue;
                    if (visited[nextBoxRow][nextBoxCol][x][y]) continue;
                    visited[nextBoxRow][nextBoxCol][x][y] = true;
                    queue.add(new int[]{x, y, nextBoxRow, nextBoxCol});
                }
            }
        }
        return -1;
    }

    private int[] getNext(int[] info) {
        int x = info[0], y = info[1];
        int boxRow = info[2], boxCol = info[3];
        boxRow += boxRow - x;
        boxCol += boxCol - y;
        return new int[]{boxRow, boxCol};
    }

    boolean pathExists(int x, int y, int targetRow, int targetCol, char[][] grid, boolean[][] visited, int boxRow, int boxCol) {
        int n = grid.length, m = grid[0].length;
        if (x == n || y == m || x < 0 || y < 0 || visited[x][y] || grid[x][y] == '#') return false;
        if (x == boxRow && y == boxCol) return false;

        visited[x][y] = true;
        if (x == targetRow && y == targetCol) return true;
        for (int[] dir : dirs) {
            if (pathExists(x + dir[0], y + dir[1], targetRow, targetCol, grid, visited, boxRow, boxCol)) {
                return true;
            }
        }
        return false;
    }
}
