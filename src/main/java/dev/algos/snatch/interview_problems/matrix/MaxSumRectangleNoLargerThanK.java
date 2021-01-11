package dev.algos.snatch.interview_problems.matrix;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class MaxSumRectangleNoLargerThanK {

    /**
     * Time O(N^2Mlog(M))
     * Space O(NM)
     */
    public int maxSumSubmatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i + 1][j + 1] = matrix[i][j] + sum[i + 1][j] + sum[i][j + 1] - sum[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int k = 0; k < m; k++) {
                    int currSum = getSum(sum, i, 0, j, k);
                    Integer remaining = set.ceiling(currSum - target);
                    if (remaining != null && currSum - remaining <= target) {
                        max = Math.max(max, currSum - remaining);
                    }
                    set.add(currSum);
                }
            }
        }
        return max;
    }

    private int getSum(int[][] sum, int rowStart, int colStart, int rowEnd, int colEnd) {
        int total = sum[rowEnd + 1][colEnd + 1];
        int left = sum[rowEnd + 1][colStart];
        int top = sum[rowStart][colEnd + 1];
        int topLeft = sum[rowStart][colStart];
        return total - left - top + topLeft;
    }
}
