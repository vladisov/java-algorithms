package dev.algos.snatch.interview_problems.concurrency;

import org.junit.jupiter.api.Test;

class BlockingQueueTest {

    void baseShowcase(BlockingQueue<Integer> q) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    q.enqueue(i);
                    System.out.println("enqueued " + i);
                }
            } catch (InterruptedException ignored) {
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
                    System.out.println("Thread 2 dequeued: " + q.dequeue());
                }
            } catch (InterruptedException ignored) {
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                for (int i = 0; i < 25; i++) {
                    System.out.println("Thread 3 dequeued: " + q.dequeue());
                }
            } catch (InterruptedException ignored) {
            }
        });
        t1.start();
        Thread.sleep(4000);
        t2.start();
        t2.join();
        t3.start();
        t1.join();
        t3.join();
    }

    @Test
    void testMutex() throws InterruptedException {
        baseShowcase(new BlockingQueueMutex<>(5));
    }

    @Test
    void testCondition() throws InterruptedException {
        baseShowcase(new BlockingQueueCondition<>(5));
    }

    @Test
    void testSemaphore() throws InterruptedException {
        baseShowcase(new BlockingQueueSemaphore<>(5));
    }
}
