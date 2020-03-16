package dev.algos.snatch.interview_problems.matrix;

import dev.algos.snatch.interview_problems.graph.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MazeTest {

    @Test
    void hasPath() {
        Maze maze = new Maze();

        int[][] input = new int[][]{
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0}
        };
        boolean hasPath = maze.hasPathDfs(input, new int[]{5, 8}, new int[]{3, 8});
        assertTrue(hasPath);

        boolean hasPathBfs = maze.hasPathBfs(input, new int[]{5, 8}, new int[]{3, 8});
        assertTrue(hasPathBfs);
    }
}
