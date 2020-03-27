package dev.algos.snatch.interview_problems.binary_search;


/**
 * Given an infinite sorted array (or an array with unknown size), find if a given number ‘key’ is present in the array.
 * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
 * <p>
 * Since it is not possible to define an array with infinite (unknown) size,
 * you will be provided with an interface ArrayReader to read elements of the array.
 * ArrayReader.get(index) will return the number at index; if the array’s size is smaller than the index,
 * it will return Integer.MAX_VALUE.
 * <p>
 * Example 1:
 * <p>
 * Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 16
 * Output: 6
 * Explanation: The key is present at index '6' in the array.
 * Example 2:
 * <p>
 * Input: [4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30], key = 11
 * Output: -1
 * Explanation: The key is not present in the array.
 * Example 3:
 * <p>
 * Input: [1, 3, 8, 10, 15], key = 15
 * Output: 4
 * Explanation: The key is present at index '4' in the array.
 * Example 4:
 * <p>
 * Input: [1, 3, 8, 10, 15], key = 200
 * Output: -1
 * Explanation: The key is not present in the array.
 */
public class SearchInInfiniteNumberArray {

    /**
     * Time complexity O(logN + logN)
     * Space complexity O(1)
     */
    public int search(ArrayReader reader, int key) {
        int lo = 0, hi = 1;
        while (reader.get(hi) < key) {
            int newLo = hi + 1;
            hi += (hi - lo + 1) * 2;
            lo = newLo;
        }
        return binarySearch(reader, lo, hi, key);
    }

    private int binarySearch(ArrayReader reader, int lo, int hi, int key) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (reader.get(mid) == key) {
                return mid;
            }
            if (reader.get(mid) < key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    static class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }
}
