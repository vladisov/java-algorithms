package dev.algos.snatch.interview_problems.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].
 * Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.
 * Note:
 * A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
 * Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
 * Example 1:
 * <p>
 * Input:
 * [[0,1,10], [2,0,5]]
 * <p>
 * Output:
 * 2
 * Explanation:
 * Person #0 gave person #1 $10.
 * Person #2 gave person #0 $5.
 * <p>
 * Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
 */
public class MinimumTranfersToPayDebt {

    /**
     * N - number of users
     * Time O(T + N*2^N)
     * Space O(2^N)
     */
    int minTransfers(int[][] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] trans : arr) {
            map.put(trans[0], map.getOrDefault(trans[0], 0) - trans[2]);
            map.put(trans[1], map.getOrDefault(trans[1], 0) + trans[2]);
        }
        int[] values = new int[map.size()];
        int j = 0;
        for (int value : map.values()) {
            if (value == 0) continue;
            values[j++] = value;
        }
        return backtrack(values, 0);
    }

    int backtrack(int[] values, int start) {
        while (start < values.length && values[start] == 0) start++;
        if (start == values.length) {
            return 0;
        }
        int min = values.length;
        for (int i = start + 1; i < values.length; i++) {
            if (values[start] * values[i] < 0) {
                int old = values[i];
                values[i] = values[start] + values[i];
                min = Math.min(1 + backtrack(values, start + 1), min);
                values[i] = old;
            }
        }
        return min;
    }
}
