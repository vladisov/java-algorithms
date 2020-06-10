package dev.algos.snatch.interview_problems.dp.minimax;

/**
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.
 * <p>
 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.
 * <p>
 * Example 1:
 * Input: [1, 5, 2]
 * Output: False
 * Explanation: Initially, player 1 can choose between 1 and 2.
 * If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
 * So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
 * Hence, player 1 will never be the winner and you need to return False.
 */
public class PredictWinner {

    /**
     * Time O(N^2)
     * Space O(N^2)
     */
    public boolean predictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return predictRec(nums, 0, nums.length - 1, true, memo) >= 0;
    }

    private int predictRec(int[] nums, int lo, int hi, boolean first, Integer[][] memo) {
        if (hi < lo) {
            return 0;
        }
        if (memo[lo][hi] == null) {
            if (first) {
                memo[lo][hi] = Math.max(predictRec(nums, lo + 1, hi, false, memo) + nums[lo],
                        predictRec(nums, lo, hi - 1, false, memo) + nums[hi]);
            } else {
                memo[lo][hi] = Math.min(predictRec(nums, lo + 1, hi, true, memo) - nums[lo],
                        predictRec(nums, lo, hi - 1, true, memo) - nums[hi]);
            }
        }
        return memo[lo][hi];
    }

    /*
    Naive solution, but works
     */
    public boolean predictTheWinnerNaive(int[] nums) {
        return predictNaiveRec(nums, 0, nums.length - 1, 0, true);
    }

    private boolean predictNaiveRec(int[] nums, int lo, int hi, int score, boolean first) {
        if (hi < lo) {
            return score >= 0;
        }
        if (first) {
            return predictNaiveRec(nums, lo + 1, hi, score + nums[lo], false) ||
                    predictNaiveRec(nums, lo, hi - 1, score + nums[hi], false);
        } else {
            return predictNaiveRec(nums, lo + 1, hi, score - nums[lo], true) &&
                    predictNaiveRec(nums, lo, hi - 1, score - nums[hi], true);
        }
    }
}
