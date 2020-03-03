package dev.algos.snatch.interview_problems.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Maze2Test {

    @Test
    void test() {
        Maze2 maze = new Maze2();

        int[][] input = new int[][]{
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1},
                {1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0}
        };
        int distance = maze.shortestDistance(input, new int[]{5, 8}, new int[]{3, 8});
        assertEquals(6, distance);
    }
}
