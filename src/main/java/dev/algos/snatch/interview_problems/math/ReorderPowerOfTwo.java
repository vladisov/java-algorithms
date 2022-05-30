package dev.algos.snatch.interview_problems.math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReorderPowerOfTwo {

    /**
     * Time O(30 * 30 + N length)
     * Space O(30)
     */
    public static boolean reorderedPowerOf2(int N) {
        if (isPow2(N)) return true;
        Set<String> set = new HashSet<>();
        int x = 1, i = 1;
        while (x <= 1e9) {
            String s = Integer.toString(x);
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            set.add(new String(chs));
            x <<= i;
        }
        String s = Integer.toString(N);
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return set.contains(new String(chs));
    }

    private static boolean isPow2(int n) {
        return n != 0 && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {

    }

    public boolean reorderedPowerOf2_2(int N) {
        long c = counter(N);
        for (int i = 0; i < 32; i++)
            if (counter(1 << i) == c) return true;
        return false;
    }

    /*
    #trick
    hash integer

    215 ->
    10 ^ 215 % 10
    10000 + 10 + 100 = 10110
     */
    public long counter(int N) {
        long res = 0;
        for (; N > 0; N /= 10) res += (int) Math.pow(10, N % 10);
        return res;
    }
}
