package dev.algos.snatch.interview_problems.matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.
 */
public class SortMatrixDiagonals {

    /**
     * Time O(NMlog(min(N,M))
     * Space O(NM)
     */
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.putIfAbsent(j - i, new PriorityQueue<>());
                map.get(j - i).add(mat[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = map.get(j - i).poll();
            }
        }
        return mat;
    }

    /**
     * Time O(NM)
     * Space O(NM)
     */
    public int[][] diagonalSortBuckets(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        if (n <= 1 || m <= 1) return mat;
        int[][] result = new int[n][m];
        int i = n - 1, j = 0;
        while (i >= 0 && j <= m) {
            int[] bucket = new int[101];
            int row = i, col = j;
            while (row < n && col < m) {
                int val = mat[row++][col++];
                bucket[val]++;
            }

            row = i;
            col = j;
            for (int k = 0; k < bucket.length; k++) {
                while (bucket[k] > 0) {
                    bucket[k]--;
                    result[row++][col++] = k;
                }
            }
            if (i > 0) {
                i--;
            } else {
                j++;
            }
        }
        return result;
    }
}
