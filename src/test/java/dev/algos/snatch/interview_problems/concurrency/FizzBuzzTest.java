package dev.algos.snatch.interview_problems.concurrency;

import org.junit.jupiter.api.Test;

class FizzBuzzTest {

    @Test
    void test() {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        Thread t1 = new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.print("fizz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t4 = new Thread(() -> {
            try {
                fizzBuzz.number((num) -> System.out.print(num + " "));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
