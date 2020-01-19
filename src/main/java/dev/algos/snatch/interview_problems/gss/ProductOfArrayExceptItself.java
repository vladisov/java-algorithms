package dev.algos.snatch.interview_problems.gss;

/**
 * ### [238.Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
 * <p>
 * Difficulty: **Medium**
 * <p>
 * <p>
 * Given an array `nums` of _n_ integers where _n_ > 1,  return an array `output` such that `output[i]` is equal to the product of all the elements of `nums` except `nums[i]`.
 * <p>
 * **Example:**
 * <p>
 * ```
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * ```
 * <p>
 * **Note:** Please solve it **without division** and in O(_n_).
 * <p>
 * **Follow up:**
 * Could you solve it with constant space complexity? (The output array **does not** count as extra space for the purpose of space complexity analysis.)
 * ```
 */
public class ProductOfArrayExceptItself {

    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(n) and O(1) if output array doesnt count
     */
    int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) return nums;
        int[] res = new int[nums.length];
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k *= nums[i];
        }

        k = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= k;
            k *= nums[i];
        }
        return res;
    }
}
