package dev.algos.snatch.interview_problems.backtracking;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
 * <p>
 * <p>
 * <p>
 * Rules for a valid pattern:
 * <p>
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 * The order of keys used matters.
 * <p>
 * Explanation:
 * <p>
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * Invalid move: 4 - 1 - 3 - 6
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 * <p>
 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 * <p>
 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
 * <p>
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2
 * Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
 */
public class NumberOfPatternsAndroid {
    int[][] jumps;
    boolean[] visited;

    /**
     * Time complexity : O(n!)
     * Space complexity : O(n)
     */
    int numberOfPatterns(int m, int n) {
        jumps = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        visited = new boolean[10];
        int count = 0;
        count += helper(1, m, n, 0, 1) * 4;
        count += helper(2, m, n, 0, 1) * 4;
        count += helper(5, m, n, 0, 1);
        return count;
    }


    int helper(int index, int m, int n, int count, int len) {
        if (len > n) return count;
        if (len >= m) count++;
        len++;
        visited[index] = true;
        for (int next = 1; next <= 9; next++) {
            int jump = jumps[index][next];
            if (!visited[next] && (jump == 0 || visited[jump])) {
                count = helper(next, m, n, count, len);
            }
        }
        visited[index] = false;
        return count;
    }
}
