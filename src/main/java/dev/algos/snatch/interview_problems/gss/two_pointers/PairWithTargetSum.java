package dev.algos.snatch.interview_problems.gss.two_pointers;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 */
class PairWithTargetSum {

    int[] search(int[] arr, int targetSum) {
        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        while (leftPointer < rightPointer) {
            if (arr[leftPointer] + arr[rightPointer] == targetSum) {
                return new int[]{leftPointer, rightPointer};
            }
            if (arr[leftPointer] + arr[rightPointer] > targetSum) rightPointer--;
            else leftPointer++;
        }
        return new int[]{-1, -1};
    }
}
