package dev.algos.snatch.interview_problems.ds_design;

/**
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * <p>
 * Each function accepts a timestamp parameter (in seconds granularity)
 * and you may assume that calls are being made to the system in chronological order (ie, the timestamp is monotonically increasing). You may assume that the earliest timestamp starts at 1.
 * <p>
 * It is possible that several hits arrive roughly at the same time.
 */
public interface HitCounter {
    void hit(int timestamp);

    int getHits(int timestamp);
}

