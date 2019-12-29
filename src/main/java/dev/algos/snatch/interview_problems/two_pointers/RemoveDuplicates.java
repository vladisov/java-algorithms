package dev.algos.snatch.interview_problems.two_pointers;

/**
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing the duplicates in-place return the new length of the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 * Example 2:
 * <p>
 * Input: [2, 2, 2, 11]
 * Output: 2
 * Explanation: The first two elements after removing the duplicates will be [2, 11].
 */
public class RemoveDuplicates {

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    int remove(int[] arr) {
        if (arr.length == 0) return 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[count++] = arr[i];
            }
        }
        return count;
    }
}
