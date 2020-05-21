package dev.algos.snatch.concurrency.basics;

import org.junit.jupiter.api.Test;

class IncorrectSemaphoreExampleTest {

    @Test
    void testIncorrect() throws InterruptedException {
        var instance = new IncorrectSemaphoreExample();
        instance.incorrectExample();
    }

    @Test
    void testCorrect() throws InterruptedException {
        var instance = new IncorrectSemaphoreExample();
        instance.correctExample();
    }
}
