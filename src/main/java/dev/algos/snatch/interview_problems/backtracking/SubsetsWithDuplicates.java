package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible backtracking (the power set).
 * <p>
 * Note: The solution set must not contain duplicate backtracking.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,2]
 * Output:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class SubsetsWithDuplicates {

    /**
     * Time complexity O(2^N)
     * Space complexity O(2^N)
     */
    public List<List<Integer>> subsetsWithDupEducative(int[] nums) {
        // sort the numbers to handle duplicates
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            // if current and the previous elements are same, create new backtracking only from the backtracking
            // added in the previous step
            if (i > 0 && nums[i] == nums[i - 1]) {
                startIndex = endIndex + 1;
            }
            endIndex = subsets.size() - 1;
            for (int j = startIndex; j <= endIndex; j++) {
                // create a new subset from the existing subset and add the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }

    void backtrack(int[] nums, int start, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtrack(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
