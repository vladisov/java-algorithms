package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * <p>
 * <p>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p>
 * Example:
 * <p>
 * Input: 4
 * Output: [
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
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {

    /**
     * Time There is N possibilities to put the first queen, not more than N (N - 2)
     * to put the second one, not more than N(N - 2)(N - 4) for the third one etc.
     * In total that results in O(N!) time complexity.
     * Space O(N) ??
     */
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return List.of(List.of());
        List<List<Integer>> resultColumns = new ArrayList<>();
        backtrack(0, n, new ArrayList<>(), resultColumns);
        return generateResult(resultColumns, n);
    }

    private void backtrack(int row, int n, ArrayList<Integer> cols, List<List<Integer>> result) {
        if (row == n) {
            result.add(new ArrayList<>(cols));
        } else {
            for (int col = 0; col < n; col++) {
                cols.add(col);
                if (isValid(cols)) {
                    backtrack(row + 1, n, cols, result);
                }
                cols.remove(cols.size() - 1);
            }
        }
    }

    private boolean isValid(ArrayList<Integer> cols) {
        if (cols.size() == 1) return true;
        int lastRow = cols.size() - 1;
        for (int row = 0; row < cols.size() - 1; row++) {
            int diff = Math.abs(cols.get(row) - cols.get(lastRow));
            if (diff == 0 || diff == lastRow - row) {
                return false;
            }
        }
        return true;
    }

    private List<List<String>> generateResult(List<List<Integer>> resultColumns, int n) {
        List<List<String>> queens = new ArrayList<>();
        for (List<Integer> columns : resultColumns) {
            List<String> rows = new ArrayList<>();
            for (int col : columns) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < col; i++) {
                    sb.append(".");
                }
                sb.append("Q");
                for (int i = col + 1; i < n; i++) {
                    sb.append(".");
                }
                rows.add(sb.toString());
            }
            queens.add(rows);
        }
        return queens;
    }
}
