package dev.algos.snatch.concurrency.basics;

import org.junit.jupiter.api.Test;

class DeadlockTest {


    @Test
    void test() throws InterruptedException {
        Deadlock deadlock = new Deadlock();
        deadlock.runTest();
    }
}
