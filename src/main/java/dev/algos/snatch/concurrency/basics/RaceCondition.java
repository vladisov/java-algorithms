package dev.algos.snatch.concurrency.basics;

import java.util.Random;

public class RaceCondition {
    int randInt;
    Random random = new Random(System.currentTimeMillis());

    public static void runTest() throws InterruptedException {
        final RaceCondition rc = new RaceCondition();
        Thread thread1 = new Thread(() -> rc.printer());
        Thread thread2 = new Thread(() -> rc.modifier());


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    void printer() {
        int i = 1000000;
        while (i != 0) {
            synchronized (this) { //added the line to fix race condition
                if (randInt % 5 == 0) {
                    if (randInt % 5 != 0)
                        System.out.println(randInt);
                }
                i--;
            }
        }
    }

    void modifier() {
        int i = 1000000;
        while (i != 0) {
            synchronized (this) {
                randInt = random.nextInt(1000);
                i--;
            }
        }
    }
}
