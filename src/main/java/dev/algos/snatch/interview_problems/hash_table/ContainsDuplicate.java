package dev.algos.snatch.interview_problems.hash_table;

import java.util.HashSet;
import java.util.Set;

/**
 * ### [217.Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
 * <p>
 * Difficulty: **Easy**
 * <p>
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * <p>
 * **Example 1:**
 * <p>
 * ```
 * Input: [1,2,3,1]
 * Output: true
 * ```
 * <p>
 * **Example 2:**
 * <p>
 * ```
 * Input: [1,2,3,4]
 * Output: false
 * ```
 * <p>
 * **Example 3:**
 * <p>
 * ```
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 */
public class ContainsDuplicate {

    /**
     * Time complexity
     * O(n)
     * Space complexity
     * O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
