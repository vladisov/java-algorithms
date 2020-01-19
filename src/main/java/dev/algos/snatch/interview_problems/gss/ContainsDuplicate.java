package dev.algos.snatch.interview_problems.gss;

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate {
    boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        set.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
