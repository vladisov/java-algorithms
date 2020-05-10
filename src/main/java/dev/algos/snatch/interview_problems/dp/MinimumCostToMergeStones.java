package dev.algos.snatch.interview_problems.dp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * There are N piles of stones arranged in a row.  The i-th pile has stones[i] stones.
 * <p>
 * A move consists of merging exactly K consecutive piles into one pile, and the cost of this move is equal to the total number of stones in these K piles.
 * <p>
 * Find the minimum cost to merge all piles of stones into one pile.  If it is impossible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: stones = [3,2,4,1], K = 2
 * Output: 20
 * Explanation:
 * We start with [3, 2, 4, 1].
 * We merge [3, 2] for a cost of 5, and we are left with [5, 4, 1].
 * We merge [4, 1] for a cost of 5, and we are left with [5, 5].
 * We merge [5, 5] for a cost of 10, and we are left with [10].
 * The total cost was 20, and this is the minimum possible.
 */
public class MinimumCostToMergeStones {

    /**
     * Naive solution
     * TLE suka
     */
    public int mergeStones(int[] stones, int k) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int stone : stones) {
            list.add(stone);
        }
        return mergeRec(list, k, memo);
    }

    int mergeRec(List<Integer> list, int k, Map<List<Integer>, Integer> memo) {
        if (list.size() == 1) return 0;
        if (list.size() < k) return -1;

        if (memo.containsKey(list)) return memo.get(list);

        int cost = Integer.MAX_VALUE;
        for (int i = 0; i <= list.size() - k; i++) {
            List<Integer> sub = new LinkedList<>();
            int subSum = 0;
            for (int j = i; j < i + k; j++) {
                sub.add(list.get(i));
                subSum += list.get(i);
                list.remove(i);
            }
            list.add(i, subSum);
            int subCost = mergeRec(list, k, memo);
            if (subCost == -1) return -1;
            cost = Math.min(cost, subSum + subCost);
            list.remove(i);
            list.addAll(i, sub);
        }
        memo.put(list, cost);
        return cost;
    }
}
