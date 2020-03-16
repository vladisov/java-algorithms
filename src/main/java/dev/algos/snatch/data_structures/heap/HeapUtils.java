package dev.algos.snatch.data_structures.heap;

public class HeapUtils {

    private void maxHeapify(int[] arr, int n, int i) {
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
            maxHeapify(arr, n, largest);
        }
    }

    private void minHeapify(int[] arr, int n, int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < n && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;
            minHeapify(arr, n, smallest);
        }
    }

    public void buildMaxHeap(int[] arr) {
        buildHeap(arr, true);
    }

    /**
     * Time complexity O(n)
     */
    private void buildHeap(int[] arr, boolean maxHeap) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            if (maxHeap) {
                maxHeapify(arr, arr.length, i);
            } else {
                minHeapify(arr, arr.length, i);
            }
        }
    }

    public void buildMinHeap(int[] arr) {
        buildHeap(arr, false);
    }

    public void heapSort(int[] arr) {
        buildMaxHeap(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            maxHeapify(arr, i, 0);
        }
    }
}
