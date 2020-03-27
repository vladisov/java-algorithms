package dev.algos.snatch.sorts;

import java.util.Arrays;

public class SortsPlayground {

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
        for (int i = lo, j = 0; j < left.length; i++, j++) {
            left[j] = arr[i];
        }
        for (int i = mid + 1, j = 0; j < right.length; i++, j++) {
            right[j] = arr[i];
        }
        int k = 0, m = 0;
        while (k < left.length && m < right.length) {
            if (left[k] < right[m]) {
                arr[lo++] = left[k++];
            } else {
                arr[lo++] = right[m++];
            }
        }
        while (k < left.length) {
            arr[lo++] = left[k++];
        }
        while (m < right.length) {
            arr[lo++] = right[m++];
        }
    }

    static void heapSort(int[] arr) {
        int n = arr.length;
        buildMaxHeap(arr);
        for (int i = n - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr, n, largest);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    static void quickSort(int[] arr, int lo, int hi) {
        if (hi - lo < 2) {
            return;
        }
        int pivotIndex = partition(arr, lo, hi);
        quickSort(arr, lo, pivotIndex);
        quickSort(arr, pivotIndex + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
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

    public static void main(String[] args) {
        var arr = initArr();
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        arr = initArr();
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        arr = initArr();
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] initArr() {
        return new int[]{5, 2, 1, -2, -4, 0};
    }
}
