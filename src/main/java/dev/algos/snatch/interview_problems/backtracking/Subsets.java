package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible backtracking (the power set).
 * <p>
 * Note: The solution set must not contain duplicate backtracking.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Subsets {

    public static List<List<Integer>> findSubsetsEducative(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing backtracking and insert the current number in them to create new backtracking
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }

    /**
     * Time complexity O(2^N)
     * Space complexity O(2^N)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }

    void backtrack(int[] nums, int start, List<List<Integer>> result, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(nums, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
