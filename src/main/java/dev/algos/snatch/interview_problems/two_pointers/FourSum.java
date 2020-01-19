package dev.algos.snatch.interview_problems.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number,
 * find all unique quadruplets in it, whose sum is equal to the target number.
 * <p>
 * Example 1:
 * <p>
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 * Example 2:
 * <p>
 * Input: [2, 0, -1, 1, -2, 2], target=2
 * Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 */
public class FourSum {

    /**
     * Time complexity
     * Sorting the array will take O(N*logN). Overall searchQuadruplets() will take
     * O(N * logN + N^3) which equals to O(N^3)
     * <p>
     * Space complexity
     * The space complexity of the above algorithm will be O(N)
     * which is required for sorting.
     */
    List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr.length == 0) return res;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            if (i == 0 || arr[i] > arr[i - 1]) {
                for (int j = i + 1; j < arr.length - 2; j++) {
                    if (j == i + 1 || arr[j] > arr[j - 1]) {
                        int lo = j + 1;
                        int hi = arr.length - 1;
                        while (lo < hi) {
                            int sum = arr[i] + arr[j] + arr[lo] + arr[hi];
                            if (sum == target) {
                                res.add(Arrays.asList(arr[i], arr[j], arr[lo], arr[hi]));
                            }
                            if (sum < target) {
                                int currLo = lo;
                                while (arr[currLo] == arr[lo] && lo < hi) lo++;
                            } else {
                                int currHi = hi;
                                while (arr[currHi] == arr[hi] && lo < hi) hi--;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
