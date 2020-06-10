package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 * <p>
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class CountBits {

    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        int maxRange = 1;
        for (int i = 0, powTwo = 2; i <= num; i++) {
            if (i >= powTwo) {
                maxRange++;
                powTwo <<= 1;
            }
        }
        List<Integer>[] buckets = new List[maxRange + 1];
        buckets[1] = new ArrayList<>();
        buckets[1].addAll(List.of(0, 1));
        for (int range = 2; range <= maxRange; range++) {
            buckets[range] = new ArrayList<>();
            for (int i = range - 1; i > 0; i--) {
                for (int j : buckets[range - i]) {
                    buckets[range].add(1 + j);
                }
            }
        }
        for (int i = 1, idx = 0; i < buckets.length && idx < res.length; i++) {
            for (int j = 0; j < buckets[i].size() && idx < res.length; j++) {
                res[idx++] = buckets[i].get(j);
            }
        }
        return res;
    }

    /**
     * Time O(N)
     * Space O(N)
     */
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for (int i = 1, offset = 1; i <= num; i++) {
            if (offset << 1 == i) {
                offset <<= 1;
            }
            res[i] = 1 + res[i - offset];
        }
        return res;
    }
}
