package dev.algos.snatch.interview_problems.merge_intervals;

import dev.algos.snatch.interview_problems.helpers.Job;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Maximum CPU Load (hard) #
 * We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
 * Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
 * <p>
 * Example 1:
 * <p>
 * Jobs: [[1,4,3], [2,5,4], [7,9,6]]
 * Output: 7
 * Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
 * jobs are running at the same time i.e., during the time interval (2,4).
 * Example 2:
 * <p>
 * Jobs: [[6,7,10], [2,4,11], [8,12,15]]
 * Output: 15
 * Explanation: None of the jobs overlap, therefore we will take the maximum load of any job which is 15.
 * Example 3:
 * <p>
 * Jobs: [[1,4,2], [2,4,1], [3,6,5]]
 * Output: 8
 * Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4].
 */
public class MaximumCPULoad {

    public int findMaxCPULoad(List<Job> jobs) {
        if (jobs == null || jobs.isEmpty()) return 0;
        jobs.sort(Comparator.comparingInt(Job::getStart)); // sort first
        PriorityQueue<Job> minHeap = new PriorityQueue<>(Comparator.comparingInt(Job::getEnd)); // important! compare end
        int maxLoad = 0;
        int load = 0;
        for (Job job : jobs) {
            while (!minHeap.isEmpty() && job.getStart() > minHeap.peek().getEnd()) {
                load -= minHeap.poll().getCpuLoad();
            }
            minHeap.offer(job);
            load += job.getCpuLoad();
            maxLoad = Math.max(maxLoad, load);
        }
        return maxLoad;
    }
}
