package dev.algos.snatch.interview_problems.concurrency;

import org.junit.jupiter.api.Test;

class CountingSemaphoreTest {

    @Test
    void showcase() throws InterruptedException {
        final CountingSemaphore cs = new CountingSemaphore(1, 1);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    cs.acquire();
                    System.out.println("Ping " + i);
                }
            } catch (InterruptedException ignored) {
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    cs.release();
                    System.out.println("Pong " + i);
                } catch (InterruptedException ignored) {
                }
            }
        });

        t2.start();
        t1.start();
        t1.join();
        t2.join();
    }
}
