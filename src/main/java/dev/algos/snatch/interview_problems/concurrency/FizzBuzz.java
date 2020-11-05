package dev.algos.snatch.interview_problems.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private final int n;
    private final Semaphore num = new Semaphore(1);
    private final Semaphore fizz = new Semaphore(0);
    private final Semaphore buzz = new Semaphore(0);
    private final Semaphore fizzbuzz = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 15 == 0) continue;
            fizz.acquire();
            printFizz.run();
            num.release();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 15 == 0) continue;
            buzz.acquire();
            printBuzz.run();
            num.release();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            fizzbuzz.acquire();
            printFizzBuzz.run();
            num.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            num.acquire();
            if (i % 15 == 0) {
                fizzbuzz.release();
            } else if (i % 3 == 0) {
                fizz.release();
            } else if (i % 5 == 0) {
                buzz.release();
            } else {
                printNumber.accept(i);
                num.release();
            }
        }
        fizzbuzz.release();
        fizz.release();
        buzz.release();
    }
}
