package dev.algos.snatch.concurrency.basics;

import java.util.concurrent.Semaphore;

public class IncorrectSemaphoreExample {

    public void incorrectExample() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);
        Thread badThread = new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                } catch (InterruptedException ie) {
                    // handle thread interruption
                }
                // Thread was meant to run forever but runs into an
                // exception that causes the thread to crash.
                throw new RuntimeException("exception happens at runtime.");

                // The following line to signal the semaphore is never reached
                // semaphore.release();
            }
        });

        badThread.start();
        // Wait for the bad thread to go belly-up
        Thread.sleep(1000);

        final Thread goodThread = new Thread(() -> {
            System.out.println("Good thread patiently waiting to be signalled.");
            try {
                semaphore.acquire();
            } catch (InterruptedException ie) {
                // handle thread interruption
            }
        });

        goodThread.start();
        badThread.join();
        goodThread.join();
        System.out.println("Exiting Program");
    }

    public void correctExample() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);
        Thread badThread = new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    try {
                        throw new RuntimeException("");
                    } catch (Exception e) {
                        // handle any program logic exception and exit the function
                        return;
                    } finally {
                        System.out.println("Bad thread releasing semahore.");
                        semaphore.release();
                    }
                } catch (InterruptedException ie) {
                    // handle thread interruption
                }
            }
        });
        badThread.start();
        // Wait for the bad thread to go belly-up
        Thread.sleep(1000);
        final Thread goodThread = new Thread(() -> {
            System.out.println("Good thread patiently waiting to be signalled.");
            try {
                semaphore.acquire();
            } catch (InterruptedException ie) {
                // handle thread interruption
            }
        });
        goodThread.start();
        badThread.join();
        goodThread.join();
        System.out.println("Exiting Program");
    }
}
