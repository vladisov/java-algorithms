package dev.algos.snatch.interview_problems.two_heaps;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * The average value of the last last k value is required, and in the calculation,
 * it is required to remove top5% and bottom5% of the k numbers.
 */
public class AverageOfK {

    Queue<Integer> queue;
    PriorityQueue<Integer> minHeap; //top 5%
    PriorityQueue<Integer> maxHeap; //bottom 5%
    int k;
    int sum;
    int minSum;
    int maxSum;

    public AverageOfK(int k) {
        this.k = k;
        this.queue = new ArrayDeque<>();
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void add(int val) {
        queue.add(val);
        sum += val;
        int fivePercent = (int) (queue.size() * 0.05);
        if (minHeap.isEmpty() || val > minHeap.peek()) {
            minHeap.add(val);
            minSum += val;
        } else if (maxHeap.isEmpty() || val < maxHeap.poll()) {
            maxHeap.add(val);
            maxSum += val;
        }

        if (maxHeap.size() > fivePercent) {
            maxSum -= maxHeap.poll();
        }
        if (minHeap.size() > fivePercent) {
            minSum -= minHeap.poll();
        }
        if (queue.size() > k) {
            int stale = queue.poll();
            sum -= stale;
            minHeap.remove(stale);
            maxHeap.remove(stale);
        }
    }

    public Double getAvarage() {
        return (sum - minSum - maxSum) * 1d / (queue.size() - minHeap.size() - maxHeap.size());
    }
}
