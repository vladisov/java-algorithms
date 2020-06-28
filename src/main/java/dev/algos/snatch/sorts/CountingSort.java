package dev.algos.snatch.sorts;

import java.util.Arrays;

public class CountingSort {

    public void sortPositives(int[] arr, int hi) {
        int[] res = new int[arr.length];
        int[] count = new int[hi + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            res[count[arr[i]] - 1] = arr[i]; // put in correct position
            count[arr[i]]--; // decrement count to put next value to index less by 1
        }
        System.arraycopy(res, 0, arr, 0, res.length);
    }

    /**
     * Time & Space O(n + k)
     */
    public void sort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            res[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.arraycopy(res, 0, arr, 0, arr.length);
    }
}
