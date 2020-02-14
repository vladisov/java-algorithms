package dev.algos.snatch.interview_problems.helpers;

public class ArrayUtils {

    public static void swap(int[] arr, int i, int j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
