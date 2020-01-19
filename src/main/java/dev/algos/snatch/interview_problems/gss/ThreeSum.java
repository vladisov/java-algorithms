package dev.algos.snatch.interview_problems.gss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {

    List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int secondPointer = i + 1;
            int thirdPointer = nums.length - 1;
            while (secondPointer < thirdPointer) {
                int sum = nums[i] + nums[secondPointer] + nums[thirdPointer];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[secondPointer], nums[thirdPointer]));
                }
                if (sum < 0) {
                    int cur = secondPointer;
                    while (nums[cur] == nums[secondPointer] && secondPointer < thirdPointer) {
                        secondPointer++;
                    }
                } else {
                    int cur = thirdPointer;
                    while (nums[cur] == nums[thirdPointer] && secondPointer < thirdPointer) {
                        thirdPointer--;
                    }
                }
            }
        }
        return result;
    }
}
