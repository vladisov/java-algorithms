package dev.algos.snatch.interview_problems.dp.fibonacci_numbers;

/**
 * Write a function to calculate the nth Fibonacci number.
 * <p>
 * Fibonacci numbers are a series of numbers in which each number is the sum of the two preceding numbers. First few Fibonacci numbers are: 0, 1, 1, 2, 3, 5, 8, …
 * <p>
 * Mathematically we can define the Fibonacci numbers as:
 * <p>
 * Fib(n) = Fib(n-1) + Fib(n-2), for n > 1
 * <p>
 * Given that: Fib(0) = 0, and Fib(1) = 1
 */
public class FibonacciNumbers {

    /**
     * Time O(N)
     * Space O(1)
     */
    public int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public int calculateFibonacciBU(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public int calculateFibonacciMemo(int n) {
        int dp[] = new int[n + 1];
        return calculateFibonacciRecursive(dp, n);
    }

    public int calculateFibonacciRecursive(int[] dp, int n) {
        if (n < 2)
            return n;
        if (dp[n] == 0)
            dp[n] = calculateFibonacciRecursive(dp, n - 1) + calculateFibonacciRecursive(dp, n - 2);
        return dp[n];
    }
}
