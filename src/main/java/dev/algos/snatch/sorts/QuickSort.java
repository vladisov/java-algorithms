package dev.algos.snatch.sorts;

public class QuickSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if (hi - lo >= 2) {
            int pivotIndex = partition(arr, lo, hi);
            sort(arr, lo, pivotIndex);
            sort(arr, pivotIndex + 1, hi);
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo;
        int j = hi;
        while (i < j) {
            while (i < j && arr[j] >= pivot) j--;
            if (i < j) {
                arr[i] = arr[j];
            }
            while (i < j && arr[i] <= pivot) i++;
            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[j] = pivot;
        return j;
    }
}
