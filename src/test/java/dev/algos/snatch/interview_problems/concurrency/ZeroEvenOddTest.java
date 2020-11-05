package dev.algos.snatch.interview_problems.concurrency;

import org.junit.jupiter.api.Test;

class ZeroEvenOddTest {

    @Test
    void testSemaphore() {
        basicTest(new ZeroEvenOddSemaphore(5));
    }

    @Test
    void testMutex() {
        basicTest(new ZeroEvenOddMutex(5));
    }

    private void basicTest(ZeroEvenOdd zeroEvenOdd) {
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
