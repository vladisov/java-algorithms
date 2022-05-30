package dev.algos.snatch.dsa.sort;

public class QuickSort {

    /**
     * Time O(NlogN)
     */
    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi - lo > 1) {
            int pivotIndex = partition(arr, lo, hi);
            quickSort(arr, lo, pivotIndex);
            quickSort(arr, pivotIndex + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo], i = lo, j = hi;
        while (i < j) {
            while (i < j && arr[j] >= pivot) j--;
            if (i < j) arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) i++;
            if (i < j) arr[j] = arr[i];
        }
        arr[j] = pivot;
        return j;
    }
}
