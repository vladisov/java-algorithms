package dev.algos.snatch.interview_problems.binary_search;

/**
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 */
public class KthGrammar {

    /**
     * Time O(log2^N)
     * Space O(1)
     */
    public int kthGrammar(int n, int k) {
        int lo = 1, hi = 1 << n, curr = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (mid <= k) {
                curr ^= 1;
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return curr;
    }
}
