package dev.algos.snatch.interview_problems.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class FooBarTest {

    @Test
    void test() {
        FooBar fooBar = new FooBarSemaphore(10);
        Runnable r1 = () -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(r1);
        executorService.execute(r2);
        executorService.shutdown();
    }

    @Test
    void testLocks() {
        FooBar fooBar = new FooBarMutex(10);
        Runnable r1 = () -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable r2 = () -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(r1);
        executorService.execute(r2);
        executorService.shutdown();
    }
}
