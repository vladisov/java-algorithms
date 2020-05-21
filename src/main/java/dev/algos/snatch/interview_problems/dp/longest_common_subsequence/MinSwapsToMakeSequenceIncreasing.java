package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

/**
 * We have two integer sequences A and B of the same non-zero length.
 * <p>
 * We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
 * <p>
 * At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
 * <p>
 * Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
 * <p>
 * Example:
 * Input: A = [1,3,5,4], B = [1,2,3,7]
 * Output: 1
 * Explanation:
 * Swap A[3] and B[3].  Then the sequences are:
 * A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
 * which are both strictly increasing.
 */
public class MinSwapsToMakeSequenceIncreasing {

    public static int minSwap(int[] A, int[] B) {
        Integer[][] dp = new Integer[A.length][B.length];

        return minSwapRec(A, B, -1, -1, 0, 0, dp);
    }

    static int minSwapRec(int[] A, int[] B, int prevA, int prevB, int i, int swapped, Integer[][] dp) {
        if (i == A.length) {
            return 0;
        }

        if (dp[i][swapped] != null) {
            return dp[i][swapped];
        }
        int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
        //swap
        if (B[i] > prevA && A[i] > prevB) {
            c1 = 1 + minSwapRec(A, B, B[i], A[i], i + 1, swapped + 1, dp);
        }
        //do not swap
        if (B[i] > prevB && A[i] > prevA) {
            c2 = minSwapRec(A, B, B[i], A[i], i + 1, swapped, dp);
        }
        dp[i][swapped] = Math.min(c1, c2);
        return dp[i][swapped];
    }
}
