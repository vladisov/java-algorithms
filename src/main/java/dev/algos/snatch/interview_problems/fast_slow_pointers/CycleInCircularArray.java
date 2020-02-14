package dev.algos.snatch.interview_problems.fast_slow_pointers;

/**
 * We are given an array containing positive and negative numbers.
 * Suppose the array contains a number ‘M’ at a particular index.
 * Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices.
 * You should assume that the array is circular which means two things:
 * <p>
 * If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
 * If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
 * Write a method to determine if the array has a cycle. The cycle should have more than one element and should follow one direction which means the cycle should not contain both forward and backward movements.
 * <p>
 * Example 1:
 * <p>
 * Input: [1, 2, -1, 2, 2]
 * Output: true
 * Explanation: The array has a cycle among indices: 0 -> 1 -> 3 -> 0
 * Example 2:
 * <p>
 * Input: [2, 2, -1, 2]
 * Output: true
 * Explanation: The array has a cycle among indices: 1 -> 3 -> 1
 * Example 3:
 * <p>
 * Input: [2, 1, -1, -2]
 * Output: false
 * Explanation: The array does not have any cycle.
 */
public class CycleInCircularArray {

    private static int findNextIndex(int[] arr, boolean isForward, int currentIndex) {
        boolean direction = arr[currentIndex] >= 0;
        if (isForward != direction)
            return -1; // change in direction, return -1

        int nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
        if (nextIndex < 0)
            nextIndex += arr.length; // wrap around for negative numbers

        // one element cycle, return -1
        if (nextIndex == currentIndex)
            nextIndex = -1;

        return nextIndex;
    }

    public boolean loopExists(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isForward = arr[i] >= 0; // if we are moving forward or not
            int slow = i, fast = i;

            // if slow or fast becomes '-1' this means we can't find cycle for this number
            do {
                slow = findNextIndex(arr, isForward, slow); // move one step for slow pointer
                fast = findNextIndex(arr, isForward, fast); // move one step for fast pointer
                if (fast != -1)
                    fast = findNextIndex(arr, isForward, fast); // move another step for fast pointer
            } while (slow != -1 && fast != -1 && slow != fast);

            if (slow != -1 && slow == fast)
                return true;
        }

        return false;
    }

    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (hasCycle(nums, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycle(int[] nums, int i) {
        boolean dir = nums[i] > 0;
        int slow = i, fast = i;
        while (slow != -1 && fast != -1 && slow != fast) {
            slow = getNext(nums, slow, dir);
            fast = getNext(nums, fast, dir);
            if (fast != -1) {
                fast = getNext(nums, fast, dir);
            }
        }
        if (slow != -1 && slow == fast) {
            return true;
        }
        return false;
    }

    private int getNext(int[] nums, int i, boolean positive) {
        boolean direction = nums[i] > 0;
        if (positive != direction) {
            return -1;
        }
        int add = nums[i];
        //[2,-3,1,2,2]
        int next;
        if (Math.abs(add) >= nums.length) {
            add = nums.length % add;
        }
        if (add > 0 && add + i >= nums.length) {
            next = add + i - nums.length;
        } else if (add + i < 0) {
            next = nums.length - (i + add);
        } else {
            next = add + i;
        }

        if (next == i) {
            return -1;
        }
        return next;
    }
}
