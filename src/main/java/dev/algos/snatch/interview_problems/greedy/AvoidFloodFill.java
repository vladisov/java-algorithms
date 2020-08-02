package dev.algos.snatch.interview_problems.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake,
 * the nth lake becomes full of water. If it rains over a lake which is full of water, there will be a flood.
 * Your goal is to avoid the flood in any lake.
 * <p>
 * Given an integer array rains where:
 * <p>
 * rains[i] > 0 means there will be rains over the rains[i] lake.
 * rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
 * Return an array ans where:
 * <p>
 * ans.length == rains.length
 * ans[i] == -1 if rains[i] > 0.
 * ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
 * If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.
 * <p>
 * Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes. (see example 4)
 * <p>
 * Example 1:
 * <p>
 * Input: rains = [1,2,3,4]
 * Output: [-1,-1,-1,-1]
 * Explanation: After the first day full lakes are [1]
 * After the second day full lakes are [1,2]
 * After the third day full lakes are [1,2,3]
 * After the fourth day full lakes are [1,2,3,4]
 * There's no day to dry any lake and there is no flood in any lake.
 */
public class AvoidFloodFill {

    /**
     * Time O(NlogN)
     * Space O(N)
     */
    public int[] avoidFlood(int[] rains) {
        int[] result = new int[rains.length];
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (lake == 0) {
                zeros.add(i);
                result[i] = 1; // take any, it will be overwritten anyways
            } else {
                if (map.containsKey(lake)) {
                    Integer day = zeros.ceiling(map.get(lake));
                    if (day == null) {
                        return new int[0];
                    }
                    result[day] = lake;
                    zeros.remove(day);
                }
                map.put(lake, i);
                result[i] = -1;
            }
        }
        return result;
    }
}
