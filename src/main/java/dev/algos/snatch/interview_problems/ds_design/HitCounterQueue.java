package dev.algos.snatch.interview_problems.ds_design;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounterQueue implements HitCounter {
    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public HitCounterQueue() {
        queue = new LinkedList<>();
    }

    /**
     * Record a hit.
     * O(1)
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        queue.offer(timestamp);
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
            queue.poll();
        }
        return queue.size();
    }
}
