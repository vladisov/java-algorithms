package dev.algos.snatch.interview_problems.binary_search;

/**
 * Given an array of numbers sorted in ascending order, find the element in the array that has the minimum difference with the given ‘key’.
 * <p>
 * Example 1:
 * <p>
 * Input: [4, 6, 10], key = 7
 * Output: 6
 * Explanation: The difference between the key '7' and '6' is minimum than any other number in the array
 * Example 2:
 * <p>
 * Input: [4, 6, 10], key = 4
 * Output: 4
 * Example 3:
 * <p>
 * Input: [1, 3, 8, 10, 15], key = 12
 * Output: 10
 * Example 4:
 * <p>
 * Input: [4, 6, 10], key = 17
 * Output: 10
 */
public class MinDifferenceElement {

    /**
     * Time O(logn)
     * Space O(n)
     */
    public int searchMinDiffElement(int[] arr, int key) {
        if (key > arr[arr.length - 1]) // if the 'key' is bigger than the biggest element
            return arr[arr.length - 1];

        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < arr[mid]) {
                end = mid - 1;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }
        if ((arr[start] - key) < (key - arr[end])) {
            return arr[start];
        }
        return arr[end];
    }
}
