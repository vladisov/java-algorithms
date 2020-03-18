package dev.algos.snatch.interview_problems.top_k;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem Statement #
 * Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
 * Output: 23
 * Explanation: The 3rd smallest number is 5 and 6th smallest number 15. The sum of numbers coming
 * between 5 and 15 is 23 (11+12).
 * Example 2:
 * <p>
 * Input: [3, 5, 8, 7], and K1=1, K2=4
 * Output: 12
 * Explanation: The sum of the numbers between the 1st smallest number (3) and the 4th smallest
 * number (8) is 12 (5+7).
 */
public class SumOfElements {

    /**
     * Time O(NlogK2 + K2logK2)
     * O(K2)
     */
    public int findSumOfElements(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        for (int num : nums) {
            queue.add(num);
            if (queue.size() >= k2) {
                queue.poll();
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        int sum = 0;
        for (int i = list.size() - k1 - 1; i >= 0; i--) {
            sum += list.get(i);
        }
        return sum;
    }

    public int findSumOfElementsAlternative(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);
        // keep smallest k2 numbers in the max heap
        for (int i = 0; i < nums.length; i++) {
            if (i < k2 - 1) {
                maxHeap.add(nums[i]);
            } else if (nums[i] < maxHeap.peek()) {
                maxHeap.poll(); // as we are interested only in the smallest k2 numbers
                maxHeap.add(nums[i]);
            }
        }

        // get the sum of numbers between k1 and k2 indices
        // these numbers will be at the top of the max heap
        int elementSum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++)
            elementSum += maxHeap.poll();

        return elementSum;
    }
}
