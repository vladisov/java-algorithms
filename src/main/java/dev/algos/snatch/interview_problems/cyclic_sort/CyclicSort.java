package dev.algos.snatch.interview_problems.cyclic_sort;

/**
 * We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique number from 1 to ‘n’
 * based on their creation sequence. This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.
 * <p>
 * Write a function to sort the objects in-place on their creation sequence number in O(n)
 * and without any extra space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers,
 * though each number is actually an object.
 * <p>
 * Example 1:
 * <p>
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 * Example 2:
 * <p>
 * Input: [2, 6, 4, 3, 1, 5]
 * Output: [1, 2, 3, 4, 5, 6]
 * Example 3:
 * <p>
 * Input: [1, 5, 6, 4, 3, 2]
 * Output: [1, 2, 3, 4, 5, 6]
 */
public class CyclicSort {

    /**
     * Time complexity O(n)
     * Space complexity O(1)
     */
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int j = nums[i] - 1;
            if (nums[j] != nums[i]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
}
