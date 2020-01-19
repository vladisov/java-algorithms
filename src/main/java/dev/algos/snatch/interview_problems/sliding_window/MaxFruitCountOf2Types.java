package dev.algos.snatch.interview_problems.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement
 * Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
 * <p>
 * You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 * <p>
 * Write a function to return the maximum number of fruits in both the baskets.
 * <p>
 * Example 1:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'A', 'C']
 * Output: 3
 * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
 * Example 2:
 * <p>
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */
public class MaxFruitCountOf2Types {

    /**
     * Time complexity
     * O(n)
     * Space complexity
     * The algorithm runs in constant space O(1)
     * as there can be a maximum of three types of fruits stored in the frequency map.
     */
    public int findLength(char[] arr) {
        if (arr.length == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, len = 0;
        while (end < arr.length) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
            end++;
            while (map.size() > 2) {
                map.put(arr[start], map.getOrDefault(arr[start], 0) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }
                start++;
            }
            len = Math.max(len, end - start);
        }
        return len;
    }
}
