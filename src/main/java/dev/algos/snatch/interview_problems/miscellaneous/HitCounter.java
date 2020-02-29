package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * <p>
 * Each function accepts a timestamp parameter (in seconds granularity)
 * and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 * <p>
 * It is possible that several hits arrive roughly at the same time.
 */
interface HitCounter {
    void hit(int timestamp);

    int getHits(int timestamp);
}

class HitCounterMap implements HitCounter {
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

class HitCounterQueue implements HitCounter {
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

class HitCounterSet implements HitCounter {
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
