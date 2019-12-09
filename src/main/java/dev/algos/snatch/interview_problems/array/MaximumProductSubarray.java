package dev.algos.snatch.interview_problems.array;

/**
 * ### [152.Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)
 * <p>
 * Difficulty: **Medium**
 * <p>
 * <p>
 * Given an integer array `nums`, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * **Example 1:**
 * <p>
 * ```
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * ```
 * <p>
 * **Example 2:**
 * <p>
 * ```
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {

    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(n)
     */
    int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        max[0] = nums[0];
        min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);
            min[i] = Math.min(Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);
            res = Math.max(max[i], res);
        }
        return res;
    }

    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(1)
     */
    public int maxProductOptimized(int[] nums) {
        //TODO
        return 0;
    }
}
