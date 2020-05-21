package dev.algos.snatch.concurrency.basics;

import java.util.concurrent.Semaphore;

public class MissingSignal {

    Semaphore semaphore = new Semaphore(1);

    public void example() throws InterruptedException {
        var signaler = new Thread(() -> {
            System.out.println("Do something in signaler");
            semaphore.release();
            System.out.println("Signal sent");
        });

        var waiter = new Thread(() -> {
            System.out.println("Do something in waiter");
            try {
                semaphore.acquire();
                System.out.println("Signal Received");
            } catch (InterruptedException ignored) {
            }
        });

        signaler.start();
        signaler.join();
        Thread.sleep(3000);
        waiter.start();
        waiter.join();

        System.out.println("Program Exiting.");
    }
}
