package dev.algos.snatch.interview_problems.miscellaneous;

public class ReverseInteger {

    public int reverse(int x) {
        int res = 0;
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);
        while (x > 0) {
            int next = res * 10 + x % 10;
            if ((next - x % 10) / 10 != res) {
                return 0;
            }
            res = next;
            x /= 10;
        }
        return res * sign;
    }
}
