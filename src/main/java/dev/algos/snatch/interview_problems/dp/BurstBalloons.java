package dev.algos.snatch.interview_problems.dp;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * <p>
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 * <p>
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons {

    /**
     * Time O(N^3)
     * Space O(N^2)
     */
    public int maxCoins(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] nums = new int[arr.length + 2];
        nums[0] = nums[nums.length - 1] = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            nums[i] = arr[i - 1];
        }
        Integer[][] memo = new Integer[nums.length][nums.length];
        return helper(nums, 1, nums.length - 2, memo);
    }

    private int helper(int[] nums, int start, int end, Integer[][] memo) {
        if (start > end) {
            return 0;
        }
        if (memo[start][end] == null) {
            int result = 0;
            for (int i = start; i <= end; i++) {
                // we choose which one to burst last, so then we can take end and start here
                result = Math.max(result, nums[start - 1] * nums[i] * nums[end + 1] + helper(nums, start, i - 1, memo)
                        + helper(nums, i + 1, end, memo));
            }
            memo[start][end] = result;
        }
        return memo[start][end];
    }
}
