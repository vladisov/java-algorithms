package dev.algos.snatch.interview_problems.two_heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of numbers and a number ‘k’,
 * find the median of all the ‘k’ sized sub-arrays (or windows) of the array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums=[1, 2, -1, 3, 5], k = 2
 * Output: [1.5, 0.5, 1.0, 4.0]
 * Explanation: Lets consider all windows of size ‘2’:
 * <p>
 * [1, 2, -1, 3, 5] -> median is 1.5
 * [1, 2, -1, 3, 5] -> median is 0.5
 * [1, 2, -1, 3, 5] -> median is 1.0
 * [1, 2, -1, 3, 5] -> median is 4.0
 * Example 2:
 * <p>
 * Input: nums=[1, 2, -1, 3, 5], k = 3
 * Output: [1.0, 2.0, 3.0]
 * Explanation: Lets consider all windows of size ‘3’:
 * <p>
 * [1, 2, -1, 3, 5] -> median is 1.0
 * [1, 2, -1, 3, 5] -> median is 2.0
 * [1, 2, -1, 3, 5] -> median is 3.0
 */
public class SlidingWindowMedian {

    /**
     * Time complexity O(N*K) since removing takes O(K) and iterating O(N)
     * Space complexity O(k)
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            addToHeaps(minHeap, maxHeap, nums[i]);
        }

        int start = 0, end = k - 1;
        while (end < nums.length) {
            if (maxHeap.size() > minHeap.size()) {
                result[start] = maxHeap.peek();
            } else {
                result[start] = (maxHeap.peek() + minHeap.peek()) / 2.0;
            }

            end++;
            if (end == nums.length) {
                return result;
            }

            int toRemove = nums[start];
            if (toRemove <= maxHeap.peek()) {
                maxHeap.remove(toRemove);
            } else {
                minHeap.remove(toRemove);
            }
            rebalanceHeaps(minHeap, maxHeap);

            start++;
            addToHeaps(minHeap, maxHeap, nums[end]);
        }
        return result;
    }

    void addToHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int val) {
        if (maxHeap.isEmpty() || maxHeap.peek() >= val) {
            maxHeap.add(val);
        } else {
            minHeap.add(val);
        }
        rebalanceHeaps(minHeap, maxHeap);
    }

    private void rebalanceHeaps(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
}
