package dev.algos.snatch.interview_problems.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * <p>
 * Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 * <p>
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input 1: a maze represented by a 2D array
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * <p>
 * Output: 12
 * <p>
 * Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
 * The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
 */
public class Maze2 {


    int[][] directions = new int[][]{
            {0, 1},
            {0, -1},
            {-1, 0},
            {1, 0}
    };

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // directions to top, bottom, left and right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // record shotest distance
        int[][] distance = new int[maze.length][maze[0].length];
        // Set all cell as -1
        for (int[] a : distance) {
            Arrays.fill(a, -1);
        }
        // Initialize start distance to 0
        distance[start[0]][start[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int[] point = q.poll();
            for (int[] dir : dirs) {
                int count = distance[point[0]][point[1]];
                int row = point[0];
                int col = point[1];
                while (row + dir[0] >= 0 && row + dir[0] < maze.length && col + dir[1] >= 0 && col + dir[1] < maze[0].length && maze[row + dir[0]][col + dir[1]] != 1) {
                    row += dir[0];
                    col += dir[1];
                    count++;
                }
                // If this cell is first time to reach or the distance to this cell is shorter
                // add it to queue and update distance
                if (distance[row][col] == -1 || distance[row][col] > count) {
                    q.add(new int[]{row, col});
                    distance[row][col] = count;
                }
            }
        }
        return distance[destination[0]][destination[1]];
    }
}
