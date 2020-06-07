package dev.algos.snatch.interview_problems.graph;

import dev.algos.snatch.interview_problems.helpers.UnionFind;

/**
 * In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.
 * <p>
 * (Note that backslash characters are escaped, so a \ is represented as "\\".)
 * <p>
 * Return the number of regions.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * " /",
 * "/ "
 * ]
 * Output: 2
 */
public class RegionsCutBySlashes {

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    /**
     * UF solution
     */
    int n;

    /**
     * Time O(N*M * 3)
     * Space O(N*M * 3)
     */
    public int regionsBySlashes(String[] grid) {
        int n = grid.length, m = n * 3;
        int[][] squares = new int[m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char slash = grid[i].charAt(j);
                if (slash == ' ') continue;
                fillSquare(squares, slash == '/', i * 3, j * 3);
            }
        }
        return numberOfIslands(squares);
    }

    private int numberOfIslands(int[][] squares) {
        int n = squares.length, num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (squares[i][j] == 0) {
                    num++;
                    dfs(squares, i, j);
                }
            }
        }
        return num;
    }

    void dfs(int[][] squares, int i, int j) {
        if (i < 0 || j < 0 || i == squares.length || j == squares.length || squares[i][j] != 0) return;
        squares[i][j] = 1;
        for (int[] dir : dirs) dfs(squares, dir[0] + i, dir[1] + j);
    }

    void fillSquare(int[][] squares, boolean frontSlash, int row, int col) {
        squares[row][col] = frontSlash ? 0 : 1;
        squares[row][col + 2] = frontSlash ? 1 : 0;
        squares[row + 1][col + 1] = 1;
        squares[row + 2][col] = frontSlash ? 1 : 0;
        squares[row + 2][col + 2] = frontSlash ? 0 : 1;
    }

    //TODO  wtf??
    public int regionsBySlashesLC(String[] grid) {
        n = grid.length;
        int total = n * n * 4;
        UnionFind uf = new UnionFind(total);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) uf.union(g(i - 1, j, 2), g(i, j, 0));
                if (j > 0) uf.union(g(i, j - 1, 1), g(i, j, 3));
                if (grid[i].charAt(j) != '/') {
                    uf.union(g(i, j, 0), g(i, j, 1));
                    uf.union(g(i, j, 2), g(i, j, 3));
                }
                if (grid[i].charAt(j) != '\\') {
                    uf.union(g(i, j, 0), g(i, j, 3));
                    uf.union(g(i, j, 2), g(i, j, 1));
                }
            }
        }
        return uf.getSize();
    }

    public int g(int i, int j, int k) {
        return (i * n + j) * 4 + k;
    }
}
