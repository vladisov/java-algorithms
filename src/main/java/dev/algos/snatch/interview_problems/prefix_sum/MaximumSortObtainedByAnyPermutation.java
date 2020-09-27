package dev.algos.snatch.interview_problems.prefix_sum;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * We have an array of integers, nums, and an array of requests where requests[i] = [starti, endi]. The ith request asks for the sum of nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi]. Both starti and endi are 0-indexed.
 * <p>
 * Return the maximum total sum of all requests among all permutations of nums.
 * <p>
 * Since the answer may be too large, return it modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
 * Output: 19
 * Explanation: One permutation of nums is [2,1,3,4,5] with the following result:
 * requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
 * requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
 * Total sum: 8 + 3 = 11.
 * A permutation with a higher total sum is [3,5,4,2,1] with the following result:
 * requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
 * requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
 * Total sum: 11 + 8 = 19, which is the best that you can do.
 */
public class MaximumSortObtainedByAnyPermutation {

    int mod = 1000000007;

    /**
     * Time O(NlogN)
     * Space O(N)
     */
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int n = nums.length;
        int[] arr = new int[n + 1];

        for (int[] request : requests) {
            int start = request[0];
            int end = request[1];
            arr[start]++;
            arr[end + 1]--;
        }
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1] % mod;
        }
        Arrays.sort(nums);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> arr[b] - arr[a]);
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int index = queue.poll();
            res[index] = nums[i];
        }
        int[] pre = new int[n + 1];
        pre[1] = res[0];
        for (int i = 1; i < n; i++) {
            pre[i + 1] = (res[i] + pre[i]) % mod;
        }
        int sum = 0;
        for (int[] request : requests) {
            int start = request[0] + 1;
            int end = request[1] + 1;
            sum += (pre[end] - pre[start - 1]) % mod;
            sum %= mod;
        }
        return sum;
    }
}
