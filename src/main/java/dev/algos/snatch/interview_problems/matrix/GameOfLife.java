package dev.algos.snatch.interview_problems.matrix;

public class GameOfLife {
    int[][] dirs = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 1},
            {-1, 1},
            {1, -1},
            {-1, -1}
    };

    /**
     * O(n) time
     * O(1) space
     */
    public void gameOfLife(int[][] board) {
        if (board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = getNextState(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 2 || board[i][j] == -1) {
                    board[i][j] = 0;
                }
            }
        }
    }

    int getNextState(int[][] board, int i, int j) {
        // 2 = dead
        // 1 = alive
        int count = 0;
        for (int[] dir : dirs) {
            count += isAlive(board, i + dir[0], j + dir[1]);
        }
        if (board[i][j] == 1) {
            if (count < 2) {
                return -1;
            } else if (count > 3) {
                return -1;
            } else {
                return 1;
            }
        } else {
            if (count == 3) {
                return -2;
            } else {
                return 2;
            }
        }
    }

    private int isAlive(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return 0;
        }
        return 1 == Math.abs(board[i][j]) ? 1 : 0;
    }


    /*
    using bits

    [2nd bit, 1st bit] = [next state, current state]

    - 00  dead (next) <- dead (current)
    - 01  dead (next) <- live (current)
    - 10  live (next) <- dead (current)
    - 11  live (next) <- live (current)
    In the beginning, every cell is either 00 or 01.
    Notice that 1st state is independent of 2nd state.
    Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
    Let's count # of neighbors from 1st state and set 2nd state bit.
    Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
    In the end, delete every cell's 1st state by doing >> 1.
    For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

    Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
    Transition 00 -> 10: when board == 0 and lives == 3.
    To get the current state, simply do

    board[i][j] & 1
    To get the next state, simply do

    board[i][j] >> 1
     */
    public void gameOfLife2(int[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(board, m, n, i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state.
            }
        }
    }

    public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}
