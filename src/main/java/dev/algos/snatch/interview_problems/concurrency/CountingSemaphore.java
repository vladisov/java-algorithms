package dev.algos.snatch.interview_problems.concurrency;

public class CountingSemaphore {
    private final int maxPermits;
    private int usedPermits;

    public CountingSemaphore(int maxPermits, int initialPermits) {
        this.maxPermits = maxPermits;
        this.usedPermits = maxPermits - initialPermits;
    }

    public synchronized void acquire() throws InterruptedException {
        while (usedPermits == maxPermits) wait();
        usedPermits++;
        notifyAll();
    }

    public synchronized void release() throws InterruptedException {
        while (usedPermits == 0) wait();
        usedPermits--;
        notifyAll();
    }
}
