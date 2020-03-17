package dev.algos.snatch.interview_problems.top_k;

import java.util.PriorityQueue;

/**
 * Problem Statement #
 * Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost. The cost of connecting two ropes is equal to the sum of their lengths.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 3, 11, 5]
 * Output: 33
 * Explanation: First connect 1+3(=4), then 4+5(=9), and then 9+11(=20). So the total cost is 33 (4+9+20)
 * Example 2:
 * <p>
 * Input: [3, 4, 5, 6]
 * Output: 36
 * Explanation: First connect 3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)
 * Example 3:
 * <p>
 * Input: [1, 3, 11, 5, 2]
 * Output: 42
 * Explanation: First connect 1+2(=3), then 3+3(=6), 6+5(=11), 11+11(=22). Total cost is 42 (3+6+11+22)
 */
public class ConnectRopes {

    /**
     * Time complexity O(NlogN)
     * Space O(N)
     */
    public int minimumCostToConnectRopes(int[] ropeLengths) {
        if (ropeLengths.length == 0) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : ropeLengths) {
            minHeap.add(rope);
        }

        int carry = 0;
        while (!minHeap.isEmpty() && minHeap.size() > 1) {
            int sum = minHeap.poll() + minHeap.poll();
            carry += sum;
            minHeap.add(sum);
        }

        return carry;
    }
}
