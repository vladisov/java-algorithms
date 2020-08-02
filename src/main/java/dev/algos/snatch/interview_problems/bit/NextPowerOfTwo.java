package dev.algos.snatch.interview_problems.bit;

public class NextPowerOfTwo {

    public int nextPowerOfTwo(int n) {
        if (n == 0) return 1;
        if ((n & (n - 1)) == 0) {
            //pow of two
            return n;
        }
        while ((n & (n - 1)) > 0) {
            n = n & (n - 1);
        }
        return n << 1;
    }
}
