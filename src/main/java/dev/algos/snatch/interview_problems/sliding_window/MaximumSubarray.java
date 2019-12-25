package dev.algos.snatch.interview_problems.sliding_window;

/**
 * ### [53.Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
 * <p>
 * Difficulty: **Easy**
 * <p>
 * <p>
 * Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * **Example:**
 * <p>
 * ```
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * ```
 * <p>
 * **Follow up:**
 * <p>
 * If you have figured out the O(_n_) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(1)
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0, j = 1, currMax = nums[0], max = currMax;
        while (j < nums.length) {
            currMax += nums[j];
            while (nums[j] > currMax && i <= j) {
                currMax -= nums[i];
                i++;
            }
            max = Math.max(currMax, max);
            j++;
        }
        return max;
    }

    /**
     * Time complexity
     * O(logn)
     * Space complexity
     * O(1)
     */
    int maxSubArray2(int[] nums) {
        //TODO
        return 0;
    }
}
