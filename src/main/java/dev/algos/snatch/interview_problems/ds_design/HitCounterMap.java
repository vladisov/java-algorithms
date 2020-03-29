package dev.algos.snatch.interview_problems.ds_design;

import java.util.ArrayDeque;
import java.util.HashMap;

public class HitCounterMap implements HitCounter {
    ArrayDeque<Integer> queue;
    HashMap<Integer, Integer> frequency;

    /**
     * Initialize your data structure here.
     */
    public HitCounterMap() {
        queue = new ArrayDeque<>();
        frequency = new HashMap<>();
    }

    /**
     * Record a hit.
     * O(1)
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        frequency.put(timestamp, frequency.getOrDefault(timestamp, 0) + 1);
        if (queue.isEmpty() || queue.getLast() != timestamp) {
            queue.offer(timestamp);
        }
        //we can remove old data here if requirements say don't keep more than 300
    }

    /**
     * Return the number of hits in the past 5 minutes.
     * O(n)
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     *                  <p>
     *                  [1 1 1 300 300 300 301 301]
     */
    public int getHits(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            int old = queue.poll();
            frequency.remove(old);
        }
        int hits = 0;
        for (var entry : frequency.entrySet()) {
            hits += entry.getValue();
        }
        return hits;
    }
}
