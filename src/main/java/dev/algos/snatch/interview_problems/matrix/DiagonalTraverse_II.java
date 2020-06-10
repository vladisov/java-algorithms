package dev.algos.snatch.interview_problems.matrix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.
 * Example 1:
 * Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,4,2,7,5,3,8,6,9]
 * Example 2:
 * <p>
 * Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
 * Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 */
public class DiagonalTraverse_II {

    /**
     * Time O(N) where N number of elements
     * Space O(N)
     * <p>
     * Trick: sum of row + col on the same diagonal are always equal
     */
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int size = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int sum = i + j;
                map.putIfAbsent(sum, new LinkedList<>());
                map.get(sum).addFirst(nums.get(i).get(j));
            }
            size += nums.get(i).size();
        }
        int[] res = new int[size];
        for (int i = 0, j = 0; j < size; i++) {
            List<Integer> list = map.get(i);
            for (int val : list) {
                res[j++] = val;
            }
        }
        return res;
    }
}
