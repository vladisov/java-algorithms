package dev.algos.snatch.interview_problems.binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/create-sorted-array-through-instructions/
 */
public class CreateSortedArray {

    /**
     * Time O(N^2logN)
     * Space O(N)
     */
    public int createSortedArray(int[] instructions) {
        List<Integer> list = new ArrayList<>();
        list.add(instructions[0]);
        int cost = 0;
        for (int i = 1; i < instructions.length; i++) {
            int left = getLeft(list, instructions[i]);
            int right = getLeft(list, instructions[i] + 1);
            cost = (cost + Math.min(left, list.size() - right)) % 1_000_000_007;
            list.add(left, instructions[i]); // insert position
        }
        return cost;
    }

    private int getLeft(List<Integer> list, int num) {
        int lo = 0, hi = list.size(); //use size if you want to find insert pos
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (num <= list.get(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
