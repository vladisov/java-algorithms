package dev.algos.snatch.interview_problems.backtracking;

/**
 * We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
 * <p>
 * A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.(Note that the rotated number can be greater than the original number.)
 * <p>
 * Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 20
 * Output: 6
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19].
 * 6 converts to 9.
 * 9 converts to 6.
 * 10 converts to 01 which is just 1.
 * 16 converts to 91.
 * 18 converts to 81.
 * 19 converts to 61.
 */
public class ConfusingNumber_II {

    public static void main(String[] args) {
        ConfusingNumber_II instance = new ConfusingNumber_II();
        instance.confusingNumberII(10);
    }

    /**
     * Time (5^M)
     * Space O(M)
     * <p>
     * O(5^m) where m=len(n). That is, m = log10(n), because it's power of 10s since N is a number
     * Since change of base formula gives logb(x) = loga(x)/loga(b),
     * => log5(n) = log10(n)/log10(5)
     * => log10(n) = log5(n) * log10(5)
     * => m = log10(n) = log5(n) x log10(5)
     * => Time complexity = (5^m) = 5^{ log5(n) x log10(5) } = (5^{log5(n)})^log10(5) = n^log10(5)
     * => Time complexity = (approx) O(n^0.7)
     */
    public int confusingNumberII(int N) {
        return helper(new int[]{0, 1, 6, 8, 9}, 0, String.valueOf(N).length(), N);
    }

    private int helper(int[] digits, int digit, int totalLen, int n) {
        if (totalLen == 0) return 0;
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            if (Integer.MAX_VALUE / 10 < digit) continue;
            int newDigit = digit * 10 + digits[i];
            if (newDigit > n) return sum;
            if (isConfusing(newDigit)) {
                sum += 1 + helper(digits, newDigit, totalLen - 1, n);
            } else if (newDigit != 0) {
                sum += helper(digits, newDigit, totalLen - 1, n);
            }
        }
        return sum;
    }

    private boolean isConfusing(int N) {
        int x = 0, tmp = N;
        while (N > 0) {
            int remainder = N % 10;
            int reversed = remainder == 6 ? 9 : remainder == 9 ? 6 : remainder;
            x = x * 10 + reversed;
            N /= 10;
        }
        return x != tmp;
    }
}
