package dev.algos.snatch.interview_problems.binary_search;

import java.util.Arrays;

public class MinimumNumberOfDaysToMakeMBouquets {

    /**
     * Time O(NlogD)
     */
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;
        double lo = 0, hi = 1e9;
        while (lo < hi) {
            int mid = (int) (lo + (hi - lo) / 2);
            int flow = 0, bouq = 0;
            for (int day : bloomDay) {
                if (mid >= day) {
                    flow++;
                } else {
                    flow = 0;
                }
                if (flow == k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq >= m) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return (int) lo;
    }

    public int minDays1(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;
        int[] days = new int[bloomDay.length];
        System.arraycopy(bloomDay, 0, days, 0, bloomDay.length);
        Arrays.sort(days);
        for (int day : days) {
            int flow = 0, bouq = 0;
            for (int bloom : bloomDay) {
                if (day >= bloom) {
                    flow++;
                } else {
                    flow = 0;
                }
                if (flow == k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq >= m) return day;
        }
        return -1;
    }
}
