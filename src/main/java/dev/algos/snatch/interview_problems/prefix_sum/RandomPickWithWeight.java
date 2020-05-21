package dev.algos.snatch.interview_problems.prefix_sum;

import java.util.Random;

/**
 * Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.
 * <p>
 * Note:
 * <p>
 * 1 <= w.length <= 10000
 * 1 <= w[i] <= 10^5
 * pickIndex will be called at most 10000 times.
 * Example 1:
 * <p>
 * Input:
 * ["Solution","pickIndex"]
 * [[[1]],[]]
 * Output: [null,0]
 * Example 2:
 * <p>
 * Input:
 * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
 * [[[1,3]],[],[],[],[],[]]
 * Output: [null,0,1,1,1,0]
 */
public class RandomPickWithWeight {

    Random random;
    int[] sum;

    /**
     * Time O(N)
     */
    public RandomPickWithWeight(int[] w) {
        this.sum = w;
        for (int i = 1; i < w.length; i++) {
            sum[i] += sum[i - 1];
        }
        random = new Random();
    }


    /**
     * Time O(logN)
     */
    public int pickIndex() {
        int max = sum[sum.length - 1];
        int r = random.nextInt(max) + 1; //range [1,max] since min weight is 1
        int lo = 0, hi = sum.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (sum[mid] == r) return mid;
            if (sum[mid] < r) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
