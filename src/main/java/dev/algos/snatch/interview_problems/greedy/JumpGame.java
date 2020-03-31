package dev.algos.snatch.interview_problems.greedy;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 */
public class JumpGame {

    /**
     * Time O(N)
     * Space O(1)
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }
            int next = nums[i] + i;
            if (next >= nums.length) {
                return true;
            }
            maxIndex = Math.max(next, maxIndex);
        }
        return maxIndex == nums.length - 1;
    }
}
