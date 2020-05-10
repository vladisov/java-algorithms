package dev.algos.snatch.concurrency.basics;

import org.junit.jupiter.api.Test;

class InterruptExampleTest {

    @Test
    void test() throws InterruptedException {
        var interrupt = new InterruptExample();
        interrupt.example();
    }
}
