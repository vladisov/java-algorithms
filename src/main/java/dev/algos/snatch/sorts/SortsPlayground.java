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

    private static void heapSort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr, i, 0);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
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
            heapify(arr, n, i);
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
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
        int j = 0, i = 0, k = lo;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start, j = end;
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


    private static int[] initArr() {
        return new int[]{5, 2, 1, -2, -4, 0};
    }
}
