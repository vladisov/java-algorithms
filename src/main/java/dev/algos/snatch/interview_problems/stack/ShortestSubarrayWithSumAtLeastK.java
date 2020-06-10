package dev.algos.snatch.interview_problems.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubarrayWithSumAtLeastK {

    public int shortestSubarray(int[] A, int K) {
        int n = A.length + 1;
        int[] preSum = new int[n];
        for (int i = 1; i < n; i++) {
            preSum[i] = A[i - 1] + preSum[i - 1]; // presum[0] = 0
        }
        //keep deque increasing
        Deque<Integer> deque = new ArrayDeque<>();
        int result = n;
        for (int i = 0; i < n; i++) {
            //if presum decreasing poll last
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.peekLast()]) {
                deque.pollLast();
            }
            //if diff >= k calculate result
            while (!deque.isEmpty() && preSum[i] - preSum[deque.peekFirst()] >= K) {
                result = Math.min(result, i - deque.pollFirst());
            }
            deque.addLast(i);
        }
        return result == n ? -1 : result;
    }
}
