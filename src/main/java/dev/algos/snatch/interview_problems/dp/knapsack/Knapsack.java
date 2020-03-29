package dev.algos.snatch.interview_problems.dp.knapsack;

/**
 * Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack which has a capacity ‘C’.
 * The goal is to get the maximum profit out of the items in the knapsack. Each item can only be selected once,
 * as we don’t have multiple quantities of any item.
 * <p>
 * Let’s take the example of Merry, who wants to carry some fruits in the knapsack to get maximum profit. Here are the weights and profits of the fruits:
 * <p>
 * Items: { Apple, Orange, Banana, Melon }
 * Weights: { 2, 3, 1, 4 }
 * Profits: { 4, 5, 3, 7 }
 * Knapsack capacity: 5
 * Result 10 Banana + Melon
 * <p>
 * Given two integer arrays to represent weights and profits of ‘N’ items,
 * we need to find a subset of these items which will give us maximum profit such that their cumulative weight is not more than a given number ‘C’.
 * Each item can only be selected once, which means either we put an item in the knapsack or we skip it.
 */
public class Knapsack {

    /**
     * Time O(n*c)
     * Space O(n*c)
     */
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
            profit1 = profits[i] + solveKnapsackRecursive(profits, weights, capacity - weights[i], i + 1, dp);
        }

        int profit2 = solveKnapsackRecursive(profits, weights, capacity, i + 1, dp);

        int max = Math.max(profit1, profit2);
        dp[i][capacity] = max;
        return max;
    }

    /**
     * Time O(n*c)
     * Space O(n*c)
     */
    public int solveKnapsackDpBrutForce(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1]; //index -> capacity

        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }


        for (int i = 1; i < profits.length; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                if (c >= weights[i]) {
                    // include the item, if it is not more than the capacity
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }
                // exclude the item
                int profit2 = dp[i - 1][c];
                // take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        printSelectedItems(dp, profits, weights, capacity);
        return dp[profits.length - 1][capacity];
    }

    private void printSelectedItems(int[][] dp, int[] profits, int[] weights, int capacity) {
        System.out.println("Selected Items: ");
        int totalProfit = dp[profits.length - 1][capacity];
        for (int i = weights.length - 1; i > 0; i--) {
            if (totalProfit != dp[i - 1][capacity]) {
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }
    }

    /**
     * Time O(n*c)
     * Space O(c)
     */
    public int solveKnapsackDp(int[] profits, int[] weights, int capacity) {
        int[] dp = new int[capacity + 1];
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[c] = profits[0];
            }
        }
        for (int i = 1; i < profits.length; i++) {
            for (int c = capacity; c >= 0; c--) {
                int profit1 = 0;
                if (c >= weights[i]) {
                    // include the item, if it is not more than the capacity
                    profit1 = profits[i] + dp[c - weights[i]];
                }
                // exclude the item
                int profit2 = dp[c];
                // take maximum
                dp[c] = Math.max(profit1, profit2);
            }
        }
        return dp[capacity];
    }
}
