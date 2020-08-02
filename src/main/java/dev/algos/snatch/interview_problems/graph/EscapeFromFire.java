package dev.algos.snatch.interview_problems.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/discuss/interview-question/762854/amazon-onsite-question-2020-rejected.
 */
public class EscapeFromFire {

    public static void main(String[] args) {
        int[][] input =
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
                        {0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };
        EscapeFromFire scratch = new EscapeFromFire();

        System.out.println(scratch.escapeFromFire(input));
    }

    public int escapeFromFire(int[][] input) {
        int n = input.length, m = input[0].length;
        Queue<Cell> queue = new ArrayDeque<>();
        List<Cell> fireCells = new ArrayList<>();
        Cell start = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (input[i][j] == 1) {
                    start = new Cell(i, j);
                }
                if (input[i][j] == 2) {
                    fireCells.add(new Cell(i, j));
                }
            }
        }
        if (start == null) return -1;

        queue.add(start);
        queue.addAll(fireCells);

        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int lvl = 0;
        while (!queue.isEmpty()) {
            lvl++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                var cell = queue.poll();
                int val = input[cell.row][cell.col];
                for (int[] dir : dirs) {
                    int r = dir[0] + cell.row;
                    int c = dir[1] + cell.col;

                    if (val == 1 && (r == 0 || c == 0 || r == n - 1 || c == m - 1)) {
                        return lvl;
                    } else if (r < 0 || c < 0 || r == n || c == m) continue;

                    if (val == 2) {
                        if (input[r][c] != 2) {
                            input[r][c] = val;
                            queue.add(new Cell(r, c));
                        }
                    }
                    if (val == 1) {
                        if (input[r][c] == 0) {
                            input[r][c] = val;
                            queue.add(new Cell(r, c));
                        }
                    }
                }
            }
            printInput(input);
        }
        return -1;
    }

    private void printInput(int[][] input) {
        for (int[] ints : input) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
    }

    static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
