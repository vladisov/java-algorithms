package dev.algos.snatch.concurrency.basics;

import org.junit.jupiter.api.Test;

class IncorrectSynchronizationTest {

    @Test
    void test() throws InterruptedException {
        IncorrectSynchronization inst = new IncorrectSynchronization();
        inst.runExample();
    }
}
