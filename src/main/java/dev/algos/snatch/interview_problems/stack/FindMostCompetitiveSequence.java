package dev.algos.snatch.interview_problems.stack;

import java.util.Stack;

public class FindMostCompetitiveSequence {

    /**
     * Time O(N)
     * Space O(K)
     */
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()] &&
                    k - (stack.size() - 1) <= nums.length - i) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.add(i);
            }
        }
        int[] res = new int[k];
        while (!stack.isEmpty()) {
            res[k - 1] = nums[stack.pop()];
            k--;
        }
        return res;
    }

    public int[] mostCompetitiveArrayBased(int[] nums, int k) {
        int[] res = new int[k];
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (j > 0 && nums[i] < res[j - 1] && k - (j - 1) <= nums.length - i) j--;
            if (j < k) res[j++] = nums[i];
        }
        return res;
    }
}
