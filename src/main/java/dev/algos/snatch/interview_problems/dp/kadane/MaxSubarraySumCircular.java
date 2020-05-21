package dev.algos.snatch.interview_problems.dp.kadane;

public class MaxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] A) {
        int[] max = new int[A.length];
        int[] min = new int[A.length];
        max[0] = A[0];
        min[0] = A[0];
        int total = A[0], maxSum = A[0], minSum = A[0];
        for (int i = 1; i < A.length; i++) {
            max[i] = Math.max(max[i - 1] + A[i], A[i]);
            min[i] = Math.min(min[i - 1] + A[i], A[i]);
            maxSum = Math.max(max[i], maxSum);
            minSum = Math.min(min[i], minSum);
            total += A[i];
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

    public int maxSubarraySumCircularOptimized(int[] A) {
        int currMin = A[0], currMax = A[0], max = currMax, min = currMin, total = A[0];
        for (int i = 1; i < A.length; i++) {
            currMax = Math.max(currMax + A[i], A[i]);
            currMin = Math.min(currMin + A[i], A[i]);
            max = Math.max(currMax, max);
            min = Math.min(currMin, min);
            total += A[i];
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }
}
