package dev.algos.snatch.interview_problems.xor;

/**
 * Problem Statement #
 * In a non-empty array of numbers, every number appears exactly twice except two numbers that appear only once. Find the two numbers that appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 4, 2, 1, 3, 5, 6, 2, 3, 5]
 * Output: [4, 6]
 * Example 2:
 * <p>
 * Input: [2, 1, 3, 2]
 * Output: [1, 3]
 */
public class TwoSingleNumbers {

    public int[] findSingleNumbers(int[] nums) {
        // get the XOR of the all the numbers
        int n1xn2 = 0;
        for (int num : nums) {
            n1xn2 ^= num;
        }

        // get the rightmost bit that is '1'
        int rightmostSetBit = 1;
        while ((rightmostSetBit & n1xn2) == 0) {
            rightmostSetBit <<= 1;
        }
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) // the bit is set
                num1 ^= num;
            else // the bit is not set
                num2 ^= num;
        }
        return new int[]{num1, num2};
    }
}
