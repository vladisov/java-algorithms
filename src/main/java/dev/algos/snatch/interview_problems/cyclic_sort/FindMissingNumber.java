package dev.algos.snatch.interview_problems.cyclic_sort;

import static dev.algos.snatch.interview_problems.helpers.ArrayUtils.swap;

public class FindMissingNumber {

    public int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]])
                swap(nums, i, nums[i]);
            else
                i++;
        }

        for (i = 0; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        return nums.length;
    }

    public int findMissingNumberXor(int[] nums) {
        int x1 = 0;
        for (int i = 1; i <= nums.length; i++) {
            x1 = x1 ^ i;
        }
        int x2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x2 = x2 ^ nums[i];
        }
        return x1 ^ x2;
    }
}
