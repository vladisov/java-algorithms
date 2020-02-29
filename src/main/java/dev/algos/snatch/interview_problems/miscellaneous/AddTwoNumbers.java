package dev.algos.snatch.interview_problems.miscellaneous;

/**
 * Write a function that adds two numbers You should not use + or any arithmetic operators
 */
public class AddTwoNumbers {

    /**
     * Time complexity O( number of digits)
     * Space complexity O( number of digits)
     */
    int add(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }
}
