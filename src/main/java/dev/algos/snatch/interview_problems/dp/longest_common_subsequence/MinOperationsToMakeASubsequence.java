package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-a-subsequence/
 */
public class MinOperationsToMakeASubsequence {

    /**
     * Time O(M + NlogN) where N - target.length, M - arr.length
     * Space O(N)
     */
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < target.length; i++) index.put(target[i], i);
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (index.containsKey(num)) {
                list.add(index.get(num));
            }
        }
        return target.length - lis(list);
    }

    int lis(List<Integer> list) {
        List<Integer> piles = new ArrayList<>();
        for (int num : list) {
            int pile = Collections.binarySearch(piles, num);
            if (pile < 0) pile = ~pile;
            if (pile == piles.size()) {
                piles.add(num);
            } else {
                piles.set(pile, num);
            }
        }
        return piles.size();
    }
}
