package dev.algos.snatch.interview_problems.max_area;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, i = 0;
        // we're looking for value where left is less and right
        while (i <= heights.length) {
            // to handle case when bars are always growing
            int height = i == heights.length ? 0 : heights[i];
            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                //if height is growing we add
                stack.push(i++);
            } else {
                // we take current element as stack pop
                int pre = stack.pop();
                int currHeight = heights[pre];
                // right boundary - i index - 1
                int right = i - 1;
                // left boundary - stack.peek + 1
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = right - left + 1;
                // calc max area here
                maxArea = Math.max(maxArea, width * currHeight);
            }
        }

        return maxArea;
    }
}
