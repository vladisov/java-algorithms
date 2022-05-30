package dev.algos.snatch.dsa.sort;

import static dev.algos.snatch.interview_problems.helpers.ArrayUtils.swap;

public class HeapSort {

    /**
     * Time O(NlogN)
     */
    public static void sort(int[] arr) {
        buildMapHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    /**
     * Time O(N)
     */
    private static void buildMapHeap(int[] arr) {
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
}
