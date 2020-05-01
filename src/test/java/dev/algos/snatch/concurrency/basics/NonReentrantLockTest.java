package dev.algos.snatch.concurrency.basics;

import org.junit.jupiter.api.Test;

class NonReentrantLockTest {

    @Test
    void test() throws InterruptedException {
        NonReentrantLock nreLock = new NonReentrantLock();

        // First locking would be successful
        nreLock.lock();
        System.out.println("Acquired first lock");

        // Second locking results in a self deadlock
        System.out.println("Trying to acquire second lock");
        nreLock.lock();
        System.out.println("Acquired second lock");
    }
}
