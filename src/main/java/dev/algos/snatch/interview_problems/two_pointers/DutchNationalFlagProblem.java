package dev.algos.snatch.interview_problems.two_pointers;

/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place.
 * You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * <p>
 * The flag of the Netherlands consists of three colors:
 * red, white and blue; and since our input array also consists of three different numbers
 * that is why it is called Dutch National Flag problem.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 * Example 2:
 * <p>
 * Input: [2, 2, 0, 1, 2, 0]
 * Output: [0 0 1 2 2 2 ]
 */
public class DutchNationalFlagProblem {

    void sort(int[] arr) {
        int lo = 0, i = 0, hi = arr.length - 1;
        while (i <= hi) {
            if (arr[i] == 0) {
                swap(arr, lo, i);
                lo++;
                i++;
            } else if (arr[i] == 1) {
                i++;
            } else {
                swap(arr, hi, i);
                hi--;
            }
        }
    }

    private void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
