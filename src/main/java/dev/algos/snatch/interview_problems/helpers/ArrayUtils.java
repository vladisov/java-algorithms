package dev.algos.snatch.interview_problems.helpers;

public class ArrayUtils {

    public static void swap(int[] arr, int i, int j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(char[] arr, int i, int j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap(Object[] arr, int i, int j) {
        var tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void reverse(char[] arr) {
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(Object[] arr) {
        reverse(arr, 0, arr.length - 1);
    }

    public static void reverse(char[] arr, int lo, int hi) {
        while (lo < hi) {
            swap(arr, lo++, hi--);
        }
    }

    public static void reverse(Object[] arr, int lo, int hi) {
        while (lo < hi) {
            swap(arr, lo++, hi--);
        }
    }
}
