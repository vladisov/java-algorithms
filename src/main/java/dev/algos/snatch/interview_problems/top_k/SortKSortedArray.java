package dev.algos.snatch.interview_problems.top_k;

import java.util.PriorityQueue;

public class SortKSortedArray {

    /**
     * Time O(NlogK)
     * Space O(N)
     */
    static void sortPartially(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            queue.add(arr[i]);
        }
        int j = 0;
        k += 1;
        while (!queue.isEmpty()) {
            arr[j++] = queue.poll();
            if (k < arr.length) {
                queue.add(arr[k++]);
            }
        }
    }
}
