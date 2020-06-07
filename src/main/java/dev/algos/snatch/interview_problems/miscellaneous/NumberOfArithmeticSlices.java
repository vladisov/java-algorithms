package dev.algos.snatch.interview_problems.miscellaneous;

public class NumberOfArithmeticSlices {

    /**
     * Time O(N)
     * Space O(1)
     */
    public static int numberOfArithmeticSlices(int[] A) {
        int end = 1, start = 0, res = 0;
        Integer prev = null;
        while (end < A.length) {
            int currDiff = A[end] - A[end - 1];
            end++;
            while (prev != null && currDiff != prev) {
                prev = A[start + 1] - A[start];
                if (prev != currDiff)
                    start++;
            }
            prev = currDiff;

            if (end - start >= 3) {
                res += end - start - 3 + 1;
            }
        }
        return res;
    }
}
