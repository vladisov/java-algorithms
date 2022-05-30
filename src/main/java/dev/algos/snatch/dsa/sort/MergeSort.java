package dev.algos.snatch.dsa.sort;

public class MergeSort {

    /**
     * Time O(NlogN)
     */
    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int[] left = new int[mid - lo + 1];
        int[] right = new int[hi - mid];
        for (int i = 0, j = lo; i < left.length; i++, j++) {
            left[i] = arr[j];
        }
        for (int i = 0, j = mid + 1; i < right.length; i++, j++) {
            right[i] = arr[j];
        }
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[lo++] = left[i++];
            } else {
                arr[lo++] = right[j++];
            }
        }
        while (i < left.length) arr[lo++] = left[i++];
        while (i < right.length) arr[lo++] = right[i++];
    }
}
