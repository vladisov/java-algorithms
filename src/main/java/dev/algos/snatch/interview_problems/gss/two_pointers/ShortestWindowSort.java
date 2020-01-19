package dev.algos.snatch.interview_problems.gss.two_pointers;

class ShortestWindowSort {

    int sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < arr.length - 1 && arr[left] <= arr[left + 1]) left++;
        if (left == arr.length - 1) return 0;
        while (right > 0 && arr[right] >= arr[right - 1]) right--;

        int subMin = Integer.MAX_VALUE;
        int subMax = Integer.MIN_VALUE;

        for (int i = left; i <= right; i++) {
            subMin = Math.min(subMin, arr[i]);
            subMax = Math.max(subMax, arr[i]);
        }

        while (left > 0 && arr[left - 1] > subMin) left--;
        while (right < arr.length - 1 && arr[right + 1] < subMax) right++;

        return right - left + 1;
    }
}
