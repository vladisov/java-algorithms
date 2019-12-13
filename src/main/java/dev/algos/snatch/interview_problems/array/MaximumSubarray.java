package dev.algos.snatch.interview_problems.array;

class MaximumSubarray {
    int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int firstPointer = 0;
        int secondPointer = 1;
        int sum = nums[0];
        int maxSum = nums[0];
        while (secondPointer < nums.length) {
            sum += nums[secondPointer];
            while (nums[secondPointer] > sum && firstPointer <= secondPointer) {
                sum -= nums[firstPointer];
                firstPointer++;
            }
            maxSum = Math.max(sum, maxSum);
            secondPointer++;
        }
        return maxSum;
    }
}
