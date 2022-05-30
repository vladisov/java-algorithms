package dev.algos.snatch.interview_problems.union_find;

import dev.algos.snatch.interview_problems.helpers.UnionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/
 */
public class MinimizeHammingDistance {

    /**
     * Time O(SlogN + N)
     * Space O(N)
     */
    public int minimumHammingDistance(int[] source, int[] target, int[][] swaps) {
        UnionFind uf = new UnionFind(source.length);
        for (int[] swap : swaps) {
            uf.union(swap[0], swap[1]);
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            int root = uf.root(i);
            map.putIfAbsent(root, new HashMap<>());
            map.get(root).put(source[i], map.get(root).getOrDefault(source[i], 0) + 1);
        }
        int distance = 0;
        for (int i = 0; i < target.length; i++) {
            int root = uf.root(i);
            var numMap = map.get(root);
            if (numMap.containsKey(target[i])) {
                numMap.put(target[i], numMap.get(target[i]) - 1);
                if (numMap.get(target[i]) == 0) {
                    numMap.remove(target[i]);
                }
                target[i] = 0;
            }
            distance += Math.abs(target[i]) > 0 ? 1 : 0;
        }
        return distance;
    }
}
