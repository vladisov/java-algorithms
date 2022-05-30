package dev.algos.snatch.interview_problems.backtracking;

public class CanPartitionKSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) {
            return false;
        }
        return helper(nums, new int[k], 0, k, sum / k, 0);
    }

    boolean helper(int[] nums, int[] sets, int isFull, int k, int sum, int index) {
        if (index == nums.length) {
            return isFull == ((1 << k) - 1);
        }
        for (int i = 0; i < k; i++) {
            if (nums[index] + sets[i] > sum || (isFull & (1 << i)) != 0) continue;
            sets[i] += nums[index];
            int nextFull = isFull;
            if (sets[i] == sum) nextFull |= (1 << i);
            if (helper(nums, sets, nextFull, k, sum, index + 1)) return true;
            sets[i] -= nums[index];
        }
        return false;
    }
}
