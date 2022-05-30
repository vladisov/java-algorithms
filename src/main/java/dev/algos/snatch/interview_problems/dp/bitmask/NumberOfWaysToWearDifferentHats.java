package dev.algos.snatch.interview_problems.dp.bitmask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NumberOfWaysToWearDifferentHats {

    int MOD = 1000000007;

    public int numberWaysNaive(List<List<Integer>> hats) {
        return backtrack(hats, 0, 0L, new HashMap());
    }

    int backtrack(List<List<Integer>> hats, int index, long visited, Map<Long, Integer> dp) {
        if (index == hats.size()) {
            return 1;
        }
        long key = visited;
        if (dp.containsKey(key)) return dp.get(key);
        var prefHats = hats.get(index);
        int count = 0;
        for (int j = 0; j < prefHats.size(); j++) {
            if ((visited & (1 << prefHats.get(j))) != 0) continue;
            int subCount = backtrack(hats, index + 1, visited | (1 << prefHats.get(j)), dp);
            count = (count + subCount) % MOD;
        }
        dp.put(key, count);
        return count;
    }

    public int numberWays(List<List<Integer>> hats) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < hats.size(); i++) {
            var preferred = hats.get(i);
            for (int hat : preferred) {
                map.putIfAbsent(hat, new ArrayList<>());
                map.get(hat).add(i);
            }
        }
        Map<Integer, Integer> idMap = new HashMap<>();
        int i = 0;
        for (int key : map.keySet()) {
            idMap.put(i++, key);
        }
        return helper(map, idMap, hats.size(), 0, 0, new int[1 << hats.size()][map.size() + 1]);
    }

    int helper(Map<Integer, List<Integer>> hats, Map<Integer, Integer> idMap, int size, int index, int visited, int[][] dp) {
        if ((1 << size) - 1 == visited) {
            return 1;
        }
        if (index == hats.size()) return 0;
        int key = idMap.get(index);
        if (dp[visited][index] != 0) return dp[visited][index];
        var people = hats.get(key);
        int count = (helper(hats, idMap, size, index + 1, visited, dp)) % MOD;
        for (int person : people) {
            if ((visited & (1 << person)) != 0) continue;
            count = (count + helper(hats, idMap, size, index + 1, visited | (1 << person), dp)) % MOD;
        }
        return dp[visited][index] = count;
    }
}
