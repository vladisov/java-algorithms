package dev.algos.snatch.interview_problems.top_k;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
 */
public class TopKNumbersInArray {

    /**
     * Time complexity O(NlogK)
     * Space complexity O(K)
     */
    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        return new ArrayList<>(queue);
    }
}
