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
}
