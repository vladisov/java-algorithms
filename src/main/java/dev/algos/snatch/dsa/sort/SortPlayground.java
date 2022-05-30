package dev.algos.snatch.dsa.sort;

import java.util.Arrays;

public class SortPlayground {

    public static void main(String[] args) {
        var arr = initArr();
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        arr = initArr();
        QuickSort.sort(arr);
        System.out.println(Arrays.toString(arr));

        arr = initArr();
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static int[] initArr() {
        return new int[]{5, 2, 1, -2, -4, 0};
    }
}
