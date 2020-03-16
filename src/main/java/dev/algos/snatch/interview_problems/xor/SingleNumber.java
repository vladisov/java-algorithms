package dev.algos.snatch.interview_problems.xor;

public class SingleNumber {

    public int findSingleNumber(int[] arr) {
        int xor = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor ^= arr[i];
        }
        return xor;
    }
}
