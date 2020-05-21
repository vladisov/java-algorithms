package dev.algos.snatch.interview_problems.reservoir_sampling;

import java.util.Random;

/**
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 * <p>
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * <p>
 * Example:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 * <p>
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */
public class RandomPickIndex {

    private final int[] nums;
    private final Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /**
     * Time O(N)
     * Space O(1) if we don't count input array
     */
    public int pick(int target) {
        if (nums.length == 0) return -1;
        int res = -1, k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (random.nextInt(k + 1) == k) {
                    res = i;
                }
                k++;
            }
        }
        return res;
    }
}
