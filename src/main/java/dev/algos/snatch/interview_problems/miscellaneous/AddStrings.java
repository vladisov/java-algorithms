package dev.algos.snatch.interview_problems.miscellaneous;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {

    /**
     * Time O(max(n,m)
     * Space O(1) if we don't count result
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int k = i < 0 ? 0 : num1.charAt(i--) - '0';
            int m = j < 0 ? 0 : num2.charAt(j--) - '0';
            int sum = (k + m + carry) % 10;
            carry = (k + m + carry) / 10;
            sb.append(sum);
        }
        if (carry == 1) sb.append(carry);
        return sb.reverse().toString();
    }
}
