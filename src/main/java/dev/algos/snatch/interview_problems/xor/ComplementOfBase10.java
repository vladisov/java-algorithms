package dev.algos.snatch.interview_problems.xor;

public class ComplementOfBase10 {

    public int bitwiseComplement(int n) {
        int x = n;
        int bitCount = 0;
        while (x != 0) {
            x >>= 1;
            bitCount++;
        }
        int allBitSet = (int) (Math.pow(2, bitCount) - 1);
        return n ^ allBitSet;
    }
}
