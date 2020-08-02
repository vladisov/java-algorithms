package dev.algos.snatch.interview_problems.dp;

import java.util.TreeMap;

public class OddEvenJumps {

    /**
     * Time O(NlogN)
     * Space O(N)
     */
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        int count = 1;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];
        higher[n - 1] = lower[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            var hi = map.ceilingEntry(A[i]);
            var lo = map.floorEntry(A[i]);
            if (hi != null) {
                higher[i] = lower[hi.getValue()];
            }
            if (lo != null) {
                lower[i] = higher[lo.getValue()];
            }
            if (higher[i]) count++;
            map.put(A[i], i);
        }
        return count;
    }
}
