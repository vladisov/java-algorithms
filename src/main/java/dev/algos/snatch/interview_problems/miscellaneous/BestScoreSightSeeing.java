package dev.algos.snatch.interview_problems.miscellaneous;


/**
 * Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two sightseeing spots i and j have distance j - i between them.
 * <p>
 * The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sightseeing spots, minus the distance between them.
 * <p>
 * Return the maximum score of a pair of sightseeing spots.
 * <p>
 * Example 1:
 * <p>
 * Input: [8,1,5,2,6]
 * Output: 11
 * Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 */
public class BestScoreSightSeeing {

    /**
     * Time O(N)
     * Space O(1)
     */
    public int maxScoreSightseeingPair(int[] A) {
        int max = 0, prev = 0;
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, A[i] + A[prev] - (i - prev));
            if (A[prev] - (i - prev) <= A[i]) {
                prev = i;
            }
        }
        return max;
    }
}
