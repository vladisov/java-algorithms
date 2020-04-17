package dev.algos.snatch.interview_problems.sliding_window;

/**
 * ou have N bulbs in a row numbered from 1 to N. Initially, all the bulbs are turned off. We turn on exactly one bulb everyday until all bulbs are on after N days.
 * <p>
 * You are given an array bulbs of length N where bulbs[i] = x means that on the (i+1)th day, we will turn on the bulb at position x where i is 0-indexed and x is 1-indexed.
 * <p>
 * Given an integer K, find out the minimum day number such that there exists two turned on bulbs that have exactly K bulbs between them that are all turned off.
 * <p>
 * If there isn't such day, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * bulbs: [1,3,2]
 * K: 1
 * Output: 2
 * Explanation:
 * On the first day: bulbs[0] = 1, first bulb is turned on: [1,0,0]
 * On the second day: bulbs[1] = 3, third bulb is turned on: [1,0,1]
 * On the third day: bulbs[2] = 2, second bulb is turned on: [1,1,1]
 * We return 2 because on the second day, there were two on bulbs with one off bulb between them.
 * Example 2:
 * <p>
 * Input:
 * bulbs: [1,2,3]
 * K: 1
 * Output: -1
 */
public class KEmptySlots {

        /*
        [1, 3, 2] di == dr

         L1      L2      L3
    D1   T

    D2   T                T

    D3   T       T        T

    */

    /**
     * Time O(n)
     * Space O(n)
     */
    public int kEmptySlots(int[] bulbs, int k) {
        int[] days = new int[bulbs.length];
        for (int i = 0; i < days.length; i++) {
            days[bulbs[i] - 1] = i + 1; // i + 1th bulb turned on on days[i] day
        }

        int res = bulbs.length + 1;
        int left = 0, right = k + 1;
        for (int i = 1; i < days.length && right < days.length; i++) {
            int di = days[i], dl = days[left], dr = days[right];
            if (di < dl || di <= dr) {
                if (di == dr) {
                    //slided till right successfully
                    res = Math.min(res, Math.max(dl, dr));
                }
                left = i;
                right = i + (k + 1);
            }
        }

        return res == bulbs.length + 1 ? -1 : res;
    }


}
