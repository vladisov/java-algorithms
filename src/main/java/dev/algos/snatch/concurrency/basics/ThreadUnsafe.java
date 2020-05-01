package dev.algos.snatch.concurrency.basics;

import java.util.Random;

public class ThreadUnsafe {

    // We'll use this to randomly sleep our threads
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        // create object of unsafe counter
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        // setup thread1 to increment the badCounter 200 times
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                badCounter.increment();
                ThreadUnsafe.sleepRandomlyForLessThan10Secs();
            }
        });

        // setup thread2 to decrement the badCounter 200 times
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                badCounter.decrement();
                ThreadUnsafe.sleepRandomlyForLessThan10Secs();
            }
        });

        // run both threads
        thread1.start();
        thread2.start();

        // wait for t1 and t2 to complete.
        thread1.join();
        thread2.join();

        // print final value of counter
        badCounter.printFinalCounterValue();
    }

    public static void sleepRandomlyForLessThan10Secs() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ignored) {
        }
    }
}

class ThreadUnsafeCounter {
    int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    void printFinalCounterValue() {
        System.out.println("counter is: " + count);
    }
}
