package dev.algos.snatch.interview_problems.max_area;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {

    /**
     * Time O(N)
     * Space O(1)
     */
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1, result = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                //if left max less -> increment left and add diff between left max and height
                result += leftMax - height[left++];
            } else {
                result += rightMax - height[right--];
            }
        }
        return result;
    }

    /**
     * Time O(N)
     * Space O(N)
     */
    public int trapStack(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, water = 0;
        while (i < height.length) {
            //if we didn't add any or height is less then last stack val
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
            } else {
                //kinda curr pointer
                int pre = stack.pop();
                if (!stack.isEmpty()) {
                    //calculate min height between left and right
                    int minHeight = Math.min(height[i], height[stack.peek()]);
                    //subtract curr pointer from minheight and calculate square
                    water += (minHeight - height[pre]) * (i - stack.peek() - 1);
                }
            }
        }
        return water;
    }
}
