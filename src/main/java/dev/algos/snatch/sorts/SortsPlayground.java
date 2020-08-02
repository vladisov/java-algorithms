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

        arr = initArr();
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

        arr = initArr();
        countingSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void countingSort(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            result[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    private static void heapSort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    static void buildMaxHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    static void heapify(int[] arr, int i, int n) {
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
            swap(arr, largest, i);
            heapify(arr, largest, n);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
        int[] right = new int[hi - mid];
        int[] left = new int[mid - lo + 1];
        for (int i = lo, j = 0; j < left.length; i++, j++) {
            left[j] = arr[i];
        }
        for (int i = mid + 1, j = 0; j < right.length; i++, j++) {
            right[j] = arr[i];
        }
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[lo++] = left[i++];
            } else {
                arr[lo++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[lo++] = left[i++];
        }
        while (j < right.length) {
            arr[lo++] = right[j++];
        }
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pivotIndex = partition(arr, lo, hi);
            quickSort(arr, lo, pivotIndex);
            quickSort(arr, pivotIndex + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi, pivot = arr[lo];
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

    private static int[] initArr() {
        return new int[]{5, 2, 1, -2, -4, 0};
    }
}
