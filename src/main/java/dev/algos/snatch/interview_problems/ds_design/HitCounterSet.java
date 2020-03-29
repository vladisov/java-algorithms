package dev.algos.snatch.interview_problems.ds_design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class HitCounterSet implements HitCounter {
    private List<Integer> list;
    private TreeSet<Integer> set;

    /**
     * Initialize your data structure here.
     */
    public HitCounterSet() {
        list = new ArrayList<>();
        set = new TreeSet<>();
    }

    /**
     * Record a hit.
     * O(logn)
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        list.add(timestamp);
        set.add(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     * O(logn)
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int time = timestamp - 300;
        if (set.contains(time)) {
            time++;
        }
        Integer target = set.ceiling(time);
        if (target == null) {
            return 0;
        }
        int i = Collections.binarySearch(list, target);
        while (i > 0 && list.get(i).equals(list.get(i - 1))) {
            i--;
        }
        return list.size() - i;
    }
}
