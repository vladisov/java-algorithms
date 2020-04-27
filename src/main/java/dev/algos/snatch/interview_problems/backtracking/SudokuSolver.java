package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

    int[][] cellsDef = new int[][]{
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8}
    };
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][] cells = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        int toSolve = preprocess(board);
        solveHelper(board, toSolve);
    }

    private boolean solveHelper(char[][] board, int toSolve) {
        if (toSolve == 0) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    List<Integer> nums = getAvailableNums(i, j);
                    if (nums.isEmpty()) return false;
                    for (int val : nums) {
                        setVisited(i, j, val, true);
                        board[i][j] = (char) (val + '0');
                        if (solveHelper(board, toSolve - 1)) {
                            return true;
                        }
                        board[i][j] = '.';
                        setVisited(i, j, val, false);
                    }
                    if (board[i][j] == '.') return false;
                }
            }
        }
        return false;
    }

    private List<Integer> getAvailableNums(int i, int j) {
        List<Integer> list = new ArrayList<>();
        for (int k = 1; k <= 9; k++) {
            if (!rows[i][k - 1] && !cols[j][k - 1] && !cells[cellsDef[i / 3][j / 3]][k - 1]) {
                list.add(k);
            }
        }
        return list;
    }

    int preprocess(char[][] board) {
        int toSolve = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    setVisited(i, j, val, true);
                } else {
                    toSolve++;
                }
            }
        }
        return toSolve;
    }

    void setVisited(int i, int j, int val, boolean visited) {
        rows[i][val - 1] = visited;
        cols[j][val - 1] = visited;
        cells[cellsDef[i / 3][j / 3]][val - 1] = visited;
    }
}
