package dev.algos.snatch.interview_problems.max_area;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaxAreaRectangle {

    /**
     * Time O(N*2M)
     * Time O(M)
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length, m = matrix[0].length, max = 0;
        int[] height = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            max = Math.max(largestHist(height), max);
        }
        return max;
    }

    /**
     * Time O(N)
     * Space O(N)
     * largest area rectangle
     */
    int largestHist(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; ) {
            int height = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int curr = heights[stack.pop()];
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                int right = i - 1;
                int width = right - left + 1;
                maxArea = Math.max(maxArea, width * curr);
            }
        }
        return maxArea;
    }
}
