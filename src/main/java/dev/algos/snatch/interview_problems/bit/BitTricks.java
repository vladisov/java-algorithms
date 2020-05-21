package dev.algos.snatch.interview_problems.bit;

public class BitTricks {

    /**
     * Shifts by n = power of n - 1
     * 1 << 1 = 2
     * 1 << 2 = 4
     * 1 << 3 = 8
     * 1 << 4 = 16
     */
    public int leftShift(int num, int i) {
        /*
            3 = 11
            3 << 1 = 110 = 3 * 2
            3 << 2 = 1100 = 3 * 4
            3 << 3 = 1100 = 3 * 8
         */
        return num << i;
    }

    /**
     * Sets flip all bits
     */
    public int complement(int num) {
        /*
            9 = 1001
            ~9 = 11111111111111111111111111110110
            32bit integer - 32 times 1 and flip 1001
         */
        return ~num;
    }

    public int setBit(int num, int i) {
        /*
            8 = 1000
            1000 | 10 = 1010
            1010 = 10
         */
        return num | (1 << i);
    }

    public boolean getBit(int num, int i) {
        /*
            8 = 1000
            if i == 0:
            1000 & 0001 = 0 -> false
            if i == 3:
            1000 & 1000 = 1 -> true
         */
        return ((num & (1 << i)) != 0);
    }

    public int flipBit(int num, int i) {
        /*
            8 = 1000
            1000 ^ 10 = 1010
            1000 ^ 1000 = 0
         */
        return num ^ (1 << i);
    }

    public int clearBit(int num, int i) {
        /*
            9 = 1001
            if i == 0
            ~1 = 11111111111111111111111111111110
            1001 & 11111111111111111111111111111110 = 1000
         */
        int mask = ~(1 << i);
        return num & mask;
    }

    public boolean checkExactlyOneBitSet(int num) {
        /*
            9 = 1001
            9 - 1 = 8 = 1000
            1000 & 1001 = 1110 != 0 -> false

            8 = 1000
            8 - 1 = 7 = 0111
            1000 & 0111 = 0000 -> true
         */
        return num != 0 && (num & (num - 1)) == 0;
    }

    public int clearBitsFromIthTo0(int num, int i) {
        /*
            7 = 111, i = 1
            -1 = 11111111111111111111111111111111
            mask = (-1 << (1 + 1)) = -1 << 2 = 11111111111111111111111111111100
            111 & 11111111111111111111111111111100 = 011
         */
        int mask = (-1 << (i + 1));
        return num & mask;
    }

    public int clearBitsFromMostSignificantBitToIth(int num, int i) {
        /*
            7 = 111, i = 2
            mask = (1 << i) - 1 = 100 - 1 = 011
            111 & 011 = 011 = 3
         */
        int mask = (1 << i) - 1;
        return num & mask;
    }
}
