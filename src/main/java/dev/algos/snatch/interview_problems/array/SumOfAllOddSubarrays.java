package dev.algos.snatch.interview_problems.array;

public class SumOfAllOddSubarrays {

    /**
     * Time O(N * (N/3))
     * Space O(N)
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n + 1];
        int sum = arr[0];
        pre[1] = arr[0];
        for (int i = 1; i < n; i++) {
            sum += arr[i];
            pre[i + 1] = pre[i] + arr[i];
            for (int j = i - 1; j > 0; j -= 2) {
                sum += pre[i + 1] - pre[j - 1];
            }
        }
        return sum;
    }

    /*
    each element present  in (n - 1) subarrays from current
    and i times (n - i) from prev
    (n - i) * i + (n - 1) = (n - 1)(i + 1)
    https://web.stanford.edu/class/cs9/sample_probs/SubarraySums.pdf
     */

    /**
     * Time O(N)
     * Space O(N)
     */
    public int sumOddLengthSubarraysOptimized(int[] arr) {
        int n = arr.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] * (((n - i) * (i + 1) + 1) / 2);
        }
        return sum;
    }
}
