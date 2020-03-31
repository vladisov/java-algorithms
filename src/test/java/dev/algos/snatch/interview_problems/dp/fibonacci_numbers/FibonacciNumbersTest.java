package dev.algos.snatch.interview_problems.dp.fibonacci_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciNumbersTest {

    @Test
    void test() {
        FibonacciNumbers instance = new FibonacciNumbers();
        assertEquals(5, instance.calculateFibonacci(5));
        assertEquals(8, instance.calculateFibonacci(6));
        assertEquals(13, instance.calculateFibonacci(7));
    }
}
