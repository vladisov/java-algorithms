package dev.algos.snatch.interview_problems.array;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    /**
     * Time complexity O(n^2)
     * Space complexity O(n)
     */
    public boolean isValidSudokuLC(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true;
    }

    /*
        Naive solution
     */
    public boolean isValidSudoku(char[][] board) {
        int n = board.length; // 9
        for (int i = 0; i < n; i++) {
            if (!validateRow(board, i) || !validateCol(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                if (!validateGrid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean validateGrid(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        return true;
    }

    private boolean validateCol(char[][] board, int i) {
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < board.length; j++) {
            char c = board[j][i];
            if (c != '.') {
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }

    private boolean validateRow(char[][] board, int i) {
        Set<Character> set = new HashSet<>();
        for (int j = 0; j < board.length; j++) {
            char c = board[i][j];
            if (c != '.') {
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }

}
