package dev.algos.snatch.interview_problems.concurrency;

import java.util.concurrent.Semaphore;

interface FooBar {
    void foo(Runnable printFoo) throws InterruptedException;

    void bar(Runnable printBar) throws InterruptedException;
}

class FooBarSemaphore implements FooBar {
    Semaphore foo;
    Semaphore bar;
    int n;

    public FooBarSemaphore(int n) {
        this.n = n;
        this.foo = new Semaphore(1);
        this.bar = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            foo.release();
        }
    }
}

class FooBarMutex implements FooBar {
    int n;
    boolean foo = true;
    boolean bar;

    public FooBarMutex(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!foo) {
                wait();
            }
            printFoo.run();
            foo = false;
            bar = true;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!bar) {
                wait();
            }
            printBar.run();
            bar = false;
            foo = true;
            notifyAll();
        }
    }
}
