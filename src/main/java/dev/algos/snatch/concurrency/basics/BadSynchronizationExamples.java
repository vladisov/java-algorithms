package dev.algos.snatch.concurrency.basics;

public class BadSynchronizationExamples {

    public static void bad1() {
        Object dummyObject = new Object();
        Object lock = new Object();

        synchronized (lock) {
            lock.notify();
            // Attempting to call notify() on the object
            // in synchronized block of another object
            dummyObject.notify();
        }
    }

    public static void bad2() throws InterruptedException {
        Object dummyObject = new Object();
        // Attempting to call wait() on the object
        // outside of a synchronized block.
        dummyObject.wait();
    }
}
