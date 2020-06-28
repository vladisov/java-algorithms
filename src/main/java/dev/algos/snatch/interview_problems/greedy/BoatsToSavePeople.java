package dev.algos.snatch.interview_problems.greedy;

import java.util.TreeMap;

/**
 * The i-th person has weight people[i], and each boat can carry a maximum weight of limit.
 * <p>
 * Each boat carries at most 2 people at the same time, provided the sum of the weight of those people is at most limit.
 * <p>
 * Return the minimum number of boats to carry every given person.  (It is guaranteed each person can be carried by a boat.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: people = [1,2], limit = 3
 * Output: 1
 * Explanation: 1 boat (1, 2)
 * Example 2:
 * <p>
 * Input: people = [3,2,2,1], limit = 3
 * Output: 3
 * Explanation: 3 boats (1, 2), (2) and (3)
 * Example 3:
 * <p>
 * Input: people = [3,5,3,4], limit = 5
 * Output: 4
 * Explanation: 4 boats (3), (3), (4), (5)
 */
public class BoatsToSavePeople {

    /**
     * Time O(nlogn)
     * Space O(N)
     */
    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int person : people) {
            map.put(person, map.getOrDefault(person, 0) + 1);
        }
        int boats = 0;
        while (!map.isEmpty()) {
            int total = 0, max = 2;
            while (!map.isEmpty() && map.firstKey() + total <= limit && max > 0) {
                int leftover = limit - total;
                int smallest = map.floorKey(leftover);
                map.put(smallest, map.get(smallest) - 1);
                if (map.get(smallest) == 0) map.remove(smallest);
                total += smallest;
                max--;
            }
            boats++;
        }
        return boats;
    }
}
