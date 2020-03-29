package dev.algos.snatch.interview_problems.dp.unbounded_knapsack;

/**
 * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’.
 * The goal is to get the maximum profit from the items in the knapsack.
 * The only difference between the 0/1 Knapsack problem and this problem is that we are allowed to use an unlimited quantity of an item.
 * <p>
 * Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit.
 * Here are the weights and profits of the fruits:
 * <p>
 * Items: { Apple, Orange, Melon }
 * Weights: { 1, 2, 3 }
 * Profits: { 15, 20, 50 }
 * Knapsack capacity: 5
 * <p>
 * Let’s try to put different combinations of fruits in the knapsack, such that their total weight is not more than 5.
 * <p>
 * 5 Apples (total weight 5) => 75 profit
 * 1 Apple + 2 Oranges (total weight 5) => 55 profit
 * 2 Apples + 1 Melon (total weight 5) => 80 profit
 * 1 Orange + 1 Melon (total weight 5) => 70 profit
 * <p>
 * This shows that 2 apples + 1 melon is the best combination, as it gives us the maximum profit and the total weight does not exceed the capacity.
 * <p>
 * Problem Statement #
 * Given two integer arrays to represent weights and profits of ‘N’ items,
 * we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’.
 * We can assume an infinite supply of item quantities; therefore, each item can be selected multiple times.
 */
public class UnboundedKnapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        Integer[][] dp = new Integer[profits.length][capacity + 1];
        return solveKnapsackRecursive(profits, weights, capacity, 0, dp);
    }

    private int solveKnapsackRecursive(int[] profits, int[] weights, int capacity, int i, Integer[][] dp) {
        if (capacity <= 0 || i >= profits.length) {
            return 0;
        }

        if (dp[i][capacity] != null) {
            return dp[i][capacity];
        }

        int profit1 = 0;

        if (weights[i] <= capacity) {
            profit1 = profits[i] + solveKnapsackRecursive(profits, weights, capacity - weights[i], i, dp);
        }

        int profit2 = solveKnapsackRecursive(profits, weights, capacity, i + 1, dp);

        int max = Math.max(profit1, profit2);
        dp[i][capacity] = max;
        return max;
    }

    public int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];
        for (int c = 0; c <= capacity; c++) {
            if (c >= weights[0]) {
                dp[0][c] = (c / weights[0]) * profits[0];
            }
        }
        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                if (c >= weights[i]) {
                    dp[i][c] = Math.max(profits[i] + dp[i][c - weights[i]], dp[i - 1][c]);
                } else {
                    dp[i][c] = dp[i - 1][c];
                }
            }
        }
        return dp[profits.length - 1][capacity];
    }
}
