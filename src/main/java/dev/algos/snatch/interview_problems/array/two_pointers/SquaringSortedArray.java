package dev.algos.snatch.interview_problems.array.two_pointers;

/**
 * Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
 */
class SquaringSortedArray {

    int[] makeSquares(int[] arr) {
        var length = arr.length - 1;
        int[] squares = new int[arr.length];
        int left = 0;
        int right = length;
        while (left <= right) {
            int leftSq = arr[left] * arr[left];
            int rightSq = arr[right] * arr[right];
            if (leftSq < rightSq) {
                squares[length--] = rightSq;
                right--;
            } else {
                squares[length--] = leftSq;
                left++;
            }
        }
        return squares;
    }
}
