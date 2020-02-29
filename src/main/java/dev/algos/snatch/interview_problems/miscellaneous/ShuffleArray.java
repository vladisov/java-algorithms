package dev.algos.snatch.interview_problems.miscellaneous;

public class ShuffleArray {

    int[] original;
    int n;

    public ShuffleArray(int[] nums) {
        original = nums;
        n = nums.length;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return original;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] current = original.clone();
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (n - i) + i);
            int tmp = current[i];
            current[i] = current[r];
            current[r] = tmp;
        }
        return current;
    }
}
