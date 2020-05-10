package dev.algos.snatch.interview_problems.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a 2D grid, each cell is either a zombie 1 or a human 0.
 * Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour.
 * Find out how many hours does it take to infect all humans?
 * <p>
 * Example:
 * <p>
 * Input:
 * [[0, 1, 1, 0, 1],
 * [0, 1, 0, 1, 0],
 * [0, 0, 0, 0, 1],
 * [0, 1, 0, 0, 0]]
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * At the end of the 1st hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [0, 1, 0, 1, 1],
 * [1, 1, 1, 0, 1]]
 * <p>
 * At the end of the 2nd hour, the status of the grid:
 * [[1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1],
 * [1, 1, 1, 1, 1]]
 */
public class ZombieInMatrix {

    /**
     * Time O(R*C)
     * Space O(R*C)
     */
    int minHours(int rows, int columns, List<List<Integer>> grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int[][] dirs = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        int lvl = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int[] dir : dirs) {
                    int[] next = new int[]{node[0] + dir[0], node[1] + dir[1]};
                    if (next[0] >= 0 && next[0] < rows && next[1] >= 0 && next[1] < columns
                            && grid.get(next[0]).get(next[1]) == 0) {
                        grid.get(next[0]).set(next[1], 1);
                        queue.add(next);
                    }
                }
            }
            if (!queue.isEmpty()) {
                lvl++;
            }
        }
        return lvl;
    }

}
