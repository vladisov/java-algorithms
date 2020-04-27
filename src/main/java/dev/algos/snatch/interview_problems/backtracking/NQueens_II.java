package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * <p>
 * <p>
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class NQueens_II {
    int num;

    /**
     * Time O(N!)
     * Space O(N)
     */
    public int totalNQueens(int n) {
        if (n == 0) return 0;
        solveNQueens(0, n, new ArrayList<>());
        return num;
    }

    void solveNQueens(int row, int n, List<Integer> cols) {
        if (row == n) {
            num++;
        } else {
            for (int i = 0; i < n; i++) {
                cols.add(i);
                if (isValid(cols)) {
                    solveNQueens(row + 1, n, cols);
                }
                cols.remove(cols.size() - 1);
            }
        }
    }

    boolean isValid(List<Integer> cols) {
        int lastRow = cols.size() - 1;
        for (int i = 0; i < cols.size() - 1; i++) {
            int diff = Math.abs(cols.get(i) - cols.get(lastRow));
            if (diff == 0 || diff == lastRow - i) {
                return false;
            }
        }
        return true;
    }
}
