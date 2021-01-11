package dev.algos.snatch.sorts;

import java.util.Arrays;

public class SortsPlayground {


    public static void main(String[] args) {
        var arr = initArr();
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        arr = initArr();
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
//
//        arr = initArr();
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        arr = initArr();
//        countingSort(arr);
//        System.out.println(Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr, int lo, int hi) {
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
        for (int i = lo, j = 0; j < left.length; i++, j++) {
            left[j] += arr[i];
        }
        for (int i = mid + 1, j = 0; j < right.length; i++, j++) {
            right[j] += arr[i];
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
        while (j < right.length) arr[lo++] = right[j++];
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (hi - lo < 2) return;
        int pivotIndex = partition(arr, lo, hi);
        quickSort(arr, lo, pivotIndex);
        quickSort(arr, pivotIndex + 1, hi);
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


    private static int[] initArr() {
        return new int[]{5, 2, 1, -2, -4, 0};
    }
}
