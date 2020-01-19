package dev.algos.snatch.interview_problems.gss.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {
    List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int firstPointer = 0; firstPointer < nums.length; firstPointer++) {
            if (firstPointer > 0 && nums[firstPointer] == nums[firstPointer - 1]) {
                continue;
            }
            for (int secondPointer = firstPointer + 1; secondPointer < nums.length; secondPointer++) {
                if (secondPointer > firstPointer + 1 && nums[secondPointer] == nums[secondPointer - 1]) {
                    continue;
                }
                int newTarget = target - (nums[firstPointer] + nums[secondPointer]);
                int thirdPointer = secondPointer + 1;
                int fourthPointer = nums.length - 1;
                while (thirdPointer < fourthPointer) {
                    int subTarget = nums[thirdPointer] + nums[fourthPointer];
                    if (subTarget == newTarget) {
                        result.add(Arrays.asList(
                                nums[firstPointer], nums[secondPointer], nums[thirdPointer], nums[fourthPointer]));
                        while (thirdPointer < fourthPointer && nums[thirdPointer] == nums[thirdPointer + 1]) {
                            thirdPointer ++;
                        }
                        while (thirdPointer < fourthPointer && nums[fourthPointer] == nums[fourthPointer - 1]) {
                            fourthPointer --;
                        }
                    }
                    if (subTarget < newTarget) {
                        int cur = thirdPointer;
                        while (cur == thirdPointer && thirdPointer < fourthPointer) {
                            thirdPointer++;
                        }
                    } else {
                        int cur = fourthPointer;
                        while (cur == fourthPointer && thirdPointer < fourthPointer) {
                            fourthPointer--;
                        }
                    }
                }
            }
        }
        return result;
    }
}
