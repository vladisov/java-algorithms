package dev.algos.snatch.interview_problems.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * We are given hours, a list of the number of hours worked per day for a given employee.
 * <p>
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
 * <p>
 * A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
 * <p>
 * Return the length of the longest well-performing interval.
 * <p>
 * Example 1:
 * <p>
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 */
public class LongestWellPerformingInterval {

    /**
     * Time O(N)
     * Space O(N)
     */
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> seen = new HashMap<>();
        int score = 0, res = 0;
        seen.putIfAbsent(0, -1);
        for (int i = 0; i < hours.length; i++) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;
            } else {
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1)) {
                    res = Math.max(res, i - seen.get(score - 1));
                }
            }
        }
        return res;
    }
}
