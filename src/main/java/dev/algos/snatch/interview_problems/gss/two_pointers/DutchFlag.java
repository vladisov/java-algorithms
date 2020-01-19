package dev.algos.snatch.interview_problems.gss.two_pointers;


class DutchFlag {

    void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int i = 0;

        while (i <= right) {
            if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 0) {
                swap(arr, i, left);
                left++;
                i++;
            } else { // 2
                swap(arr, i, right);
                right--;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        final var temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
