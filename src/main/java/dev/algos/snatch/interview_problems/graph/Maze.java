package dev.algos.snatch.interview_problems.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {

    int[][] directions = new int[][]{
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0}
    };

    public boolean hasPathBfs(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || start[0] < 0 || start[0] >= maze.length
                || start[1] < 0 || start[1] >= maze[0].length) return false;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        queue.add(start);
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (point[0] == destination[0] && point[1] == destination[1]) {
                return true;
            }
            visited[point[0]][point[1]] = true;
            for (var dir : directions) {
                int[] nextDir = getDir(point[0], point[1], dir, maze);
                if ((nextDir[0] == point[0] && nextDir[1] == point[1]) || visited[nextDir[0]][nextDir[1]]) continue;
                queue.add(nextDir);

            }
        }

        return false;
    }

    public boolean hasPathDfs(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || start[0] < 0 || start[0] >= maze.length
                || start[1] < 0 || start[1] >= maze[0].length) return false;

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        for (int[] dir : directions) {
            int[] nextDir = getDir(start[0], start[1], dir, maze);
            if (nextDir[0] == start[0] && nextDir[1] == start[1]) continue;
            if (dfs(maze, nextDir[0], nextDir[1], destination, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int[][] maze, int i, int j, int[] destination, boolean[][] visited) {
        if (i < 0 || i >= maze.length || j < 0 || j >= maze[i].length || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;

        if (i == destination[0] && j == destination[1]) {
            return true;
        }

        for (int[] dir : directions) {
            int[] nextDir = getDir(i, j, dir, maze);
            if (nextDir[0] == i && j == nextDir[1]) continue;
            if (dfs(maze, nextDir[0], nextDir[1], destination, visited)) {
                return true;
            }
        }
        return false;
    }

    private int[] getDir(int row, int col, int[] dir, int[][] maze) {
        if (maze[row][col] == 1) return new int[]{row, col};

        if (dir[0] != 0) {
            while (row + dir[0] >= 0 && row + dir[0] < maze.length && maze[row + dir[0]][col] != 1) {
                row += dir[0];
            }
        }

        if (dir[1] != 0) {
            while (col + dir[1] >= 0 && col + dir[1] < maze[row].length && maze[row][col + dir[1]] != 1) {
                col += dir[1];
            }
        }

        return new int[]{row, col};
    }
}
