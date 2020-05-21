package dev.algos.snatch.concurrency.basics;

import org.junit.jupiter.api.Test;

class MissingSignalTest {

    @Test
    void test() throws InterruptedException {
        MissingSignal example = new MissingSignal();
        example.example();
    }

}
