package dev.algos.snatch.interview_problems.dp.matrix_dp;

/**
 * You are given a rows x cols matrix grid. Initially, you are located at the top-left corner (0, 0), and in each step, you can only move right or down in the matrix.
 * <p>
 * Among all possible paths starting from the top-left corner (0, 0) and ending in the bottom-right corner (rows - 1, cols - 1), find the path with the maximum non-negative product. The product of a path is the product of all integers in the grid cells visited along the path.
 * <p>
 * Return the maximum non-negative product modulo 109 + 7. If the maximum product is negative return -1.
 * <p>
 * Notice that the modulo is performed after getting the maximum product.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [[-1,-2,-3],
 * [-2,-3,-3],
 * [-3,-3,-2]]
 * Output: -1
 * Explanation: It's not possible to get non-negative product in the path from (0, 0) to (2, 2), so return -1.
 */
public class MaximumNonNegativeProductInMatrix {

    int[][] dirs = {
            {1, 0},
            {0, 1}
    };
    int mod = 1_000_000_007;

    /**
     * Time O(4^N)
     * Space O(N)
     */
    public int maxProductPath(int[][] grid) {
        return (int) (helper(grid, 0, 0, 1L) % mod);
    }

    private long helper(int[][] grid, int i, int j, long total) {
        if (total == 0) return 0;
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j] * total;
        }

        long max = -1;
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row < grid.length && col < grid[i].length) {
                max = Math.max(helper(grid, row, col, grid[i][j] * total), max);
            }
        }
        return max;
    }

    //TODO
    public int maxProductPathMinMax(int[][] grid) {
        int product = (int) (helperMinMax(grid, 0, 0, 1L) % mod);
        return product < 0 ? -1 : product;
    }


    private long helperMinMax(int[][] grid, int i, int j, long total) {
        if (total == 0) return 0;
        if (i == grid.length - 1 && j == grid[i].length - 1) {
            return grid[i][j] * total;
        }
        int curr = grid[i][j];

        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for (int[] dir : dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row < grid.length && col < grid[i].length) {
                if (curr < 0) {
                    min = Math.min(helperMinMax(grid, row, col, curr * total), min);
                } else {
                    max = Math.max(helperMinMax(grid, row, col, curr * total), max);
                }
            }
        }
        return Math.max(min, max);
    }
}
