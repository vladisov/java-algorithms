package dev.algos.snatch.interview_problems.miscellaneous;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Follow up:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    /**
     * Time O(N)
     * Space O(1)
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(0, n - 1, nums);
        reverse(k, n - 1, nums);
        reverse(0, k - 1, nums);
    }

    void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
