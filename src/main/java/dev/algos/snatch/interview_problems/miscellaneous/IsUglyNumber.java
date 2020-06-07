package dev.algos.snatch.interview_problems.miscellaneous;

/**
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example 1:
 * <p>
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 */
public class IsUglyNumber {

    /**
     * Time O(logN)
     * Space O(1)
     */
    public boolean isUgly(int num) {
        if (num == 0) return false;
        for (int i = 2; i < 6; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
