package dev.algos.snatch.interview_problems.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public interface H2O {

    void hydrogen(Runnable releaseHydrogen) throws InterruptedException;

    void oxygen(Runnable releaseOxygen) throws InterruptedException;
}

class H2O_Mutex implements H2O {
    int h = 0;
    int o = 0;

    public synchronized void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        while (h == 2) {
            wait();
        }
        releaseHydrogen.run();
        h++;
        if (h == 2 && o == 1) {
            h = 0;
            o = 0;
        }
        notifyAll();
    }

    public synchronized void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while (o == 1) {
            wait();
        }
        releaseOxygen.run();
        o++;
        if (h == 2 && o == 1) {
            h = 0;
            o = 0;
        }
        notifyAll();
    }
}

class H2O_Barrier implements H2O {
    private final Semaphore hydrogen;
    private final Semaphore oxygen;
    private final CyclicBarrier barrier;

    public H2O_Barrier() {
        this.barrier = new CyclicBarrier(3);
        this.oxygen = new Semaphore(1);
        this.hydrogen = new Semaphore(2);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try {
            hydrogen.acquire();
            releaseHydrogen.run();
            barrier.await();
            hydrogen.release();
        } catch (BrokenBarrierException ignored) {
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            oxygen.acquire();
            releaseOxygen.run();
            barrier.await();
            oxygen.release();
        } catch (BrokenBarrierException ignored) {
        }
    }
}
