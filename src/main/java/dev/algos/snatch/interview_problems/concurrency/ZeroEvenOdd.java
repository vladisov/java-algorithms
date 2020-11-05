package dev.algos.snatch.interview_problems.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

interface ZeroEvenOdd {
    void zero(IntConsumer printNumber) throws InterruptedException;

    void even(IntConsumer printNumber) throws InterruptedException;

    void odd(IntConsumer printNumber) throws InterruptedException;
}


class ZeroEvenOddSemaphore implements ZeroEvenOdd {
    private final int n;
    private final Semaphore zero;
    private final Semaphore even;
    private final Semaphore odd;

    public ZeroEvenOddSemaphore(int n) {
        this.zero = new Semaphore(1);
        this.even = new Semaphore(0);
        this.odd = new Semaphore(0);
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (i % 2 != 0) {
                even.release();
            } else {
                odd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}

class ZeroEvenOddMutex implements ZeroEvenOdd {
    private final int n;
    boolean zero = true, even, odd;

    public ZeroEvenOddMutex(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!zero) {
                wait();
            }
            printNumber.accept(0);
            if (i % 2 != 0) {
                even = true;
            } else {
                odd = true;
            }
            zero = false;
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (!even) {
                wait();
            }
            printNumber.accept(i);
            even = false;
            zero = true;
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (!odd) {
                wait();
            }
            printNumber.accept(i);
            odd = false;
            zero = true;
            notifyAll();
        }
    }
}

