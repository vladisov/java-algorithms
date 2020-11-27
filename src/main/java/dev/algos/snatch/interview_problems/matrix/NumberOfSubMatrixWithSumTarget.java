package dev.algos.snatch.interview_problems.matrix;

import java.util.HashMap;

public class NumberOfSubMatrixWithSumTarget {

    /**
     * Time O(NM*NM)
     * Space O(NM)
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] prefix = buildSum(matrix);
        int n = matrix.length, m = matrix[0].length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        int sum = getSum(i, j, k, l, prefix);
                        if (sum == target) count++;
                    }
                }
            }
        }
        return count;
    }

    int getSum(int rowStart, int colStart, int rowEnd, int colEnd, int[][] prefix) {
        int total = prefix[rowEnd + 1][colEnd + 1];
        int left = prefix[rowEnd + 1][colStart];
        int right = prefix[rowStart][colEnd + 1];
        int top = prefix[rowStart][colStart];
        return total - left - right + top;
    }

    int[][] buildSum(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] prefix = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefix[i + 1][j + 1] = matrix[i][j] + prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j];
            }
        }
        return prefix;
    }

    /*
    0 1 0
    1 1 1
    0 1 0
     */
    public int numSubmatrixSumTargetPrefix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        /*
        0 1 0
        1 2 3
        0 1 0
        going through columns only
        [i...j]
        and by rows [0...k]
         */
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                var map = new HashMap<Integer, Integer>() {{
                    put(0, 1);
                }};
                int cur = 0;
                for (int k = 0; k < n; k++) {
                    cur += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    count += map.getOrDefault(cur - target, 0);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return count;
    }
}
