package dev.algos.snatch.sorts;

public class MergeSort {

    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            sort(arr, lo, mid);
            sort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    void merge(int[] arr, int lo, int mid, int hi) {
        int[] left = new int[mid - lo + 1];
        int[] right = new int[hi - mid];
        for (int i = 0, j = lo; i < left.length; i++) {
            left[i] = arr[j++];
        }

        for (int i = 0, j = mid + 1; i < right.length; i++) {
            right[i] = arr[j++];
        }

        int k = 0, m = 0, i = lo;
        while (k < left.length && m < right.length) {
            if (left[k] < right[m]) {
                arr[i++] = left[k++];
            } else {
                arr[i++] = right[m++];
            }
        }

        while (k < left.length) {
            arr[i++] = left[k++];
        }

        while (m < right.length) {
            arr[i++] = right[m++];
        }
    }
}
