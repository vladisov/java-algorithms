package dev.algos.snatch.interview_problems.k_way_merge;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Problem Statement #
 * Given ‘M’ sorted arrays, find the K’th smallest number among all the arrays.
 * <p>
 * Example 1:
 * <p>
 * Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
 * Output: 4
 * Explanation: The 5th smallest number among all the arrays is 4, this can be verified from the merged
 * list of all the arrays: [1, 2, 3, 3, 4, 6, 6, 7, 8]
 * Example 2:
 * <p>
 * Input: L1=[5, 8, 9], L2=[1, 7], K=3
 * Output: 7
 * Explanation: The 3rd smallest number among all the arrays is 7.
 */
public class KthSmallestInMSortedArrays {

    /**
     * Time complexity (NlogM)
     * Space O(M) m - lists size
     */
    public int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        for (int i = 0; i < lists.size(); i++) {
            minHeap.add(new int[]{lists.get(i)[0], i, 0});
        }
        int j = 0;
        while (!minHeap.isEmpty()) {
            j++;
            int[] map = minHeap.poll();
            int val = map[0];
            int arrIndex = map[1];
            int index = map[2];

            if (j == k) {
                return val;
            }

            Integer[] array = lists.get(arrIndex);
            if (index < array.length - 1) {
                val = array[++index];
                map[0] = val;
                map[2] = index;
                minHeap.offer(map);
            }
        }
        return -1;
    }
}
