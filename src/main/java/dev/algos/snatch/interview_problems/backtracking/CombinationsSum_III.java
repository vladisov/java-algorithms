package dev.algos.snatch.interview_problems.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <p>
 * Note:
 * <p>
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * <p>
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 * <p>
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationsSum_III {

    /**
     * Time and Space N^K = 9^K -> n choose k
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, result, new ArrayList<>());
        return result;
    }

    void backtrack(int k, int target, int start, List<List<Integer>> result, List<Integer> tmp) {
        if (target == 0) {
            if (k == 0) {
                result.add(new ArrayList<>(tmp));
            }
        } else {
            for (int i = start; i < 10; i++) {
                if (i > target) {
                    break;
                }
                tmp.add(i);
                backtrack(k - 1, target - i, i + 1, result, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
