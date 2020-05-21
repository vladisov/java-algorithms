package dev.algos.snatch.concurrency.basics;

public class IncorrectSynchronization {

    private Boolean flag = Boolean.TRUE;

    private void example() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            synchronized (flag) {
                try {
                    while (flag) {
                        System.out.println("First thread about to sleep");
                        Thread.sleep(5000);
                        System.out.println("Woke up and about to invoke wait()");
                        flag.wait();
                    }
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread t2 = new Thread(() -> {
            flag = false;
            System.out.println("Boolean assignment done.");
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
        t1.join();
        t2.join();
    }

    public void runExample() throws InterruptedException {
        IncorrectSynchronization incorrectSynchronization = new IncorrectSynchronization();
        incorrectSynchronization.example();
    }
}

