package dev.algos.snatch.interview_problems.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A blocking queue is defined as a queue which blocks the caller of the enqueue method
 * if there's no more capacity to add the new item being enqueued. Similarly, the queue blocks the dequeue caller
 * if there are no items in the queue. Also, the queue notifies a blocked enqueuing
 * thread when space becomes available and a blocked dequeuing thread when an item becomes available in the queue.
 */
interface BlockingQueue<T> {

    void enqueue(T item) throws InterruptedException;

    T dequeue() throws InterruptedException;

    int size();
}

class BlockingQueueMutex<T> implements BlockingQueue<T> {
    private final T[] array;
    private final int capacity;
    private volatile int size = 0;
    private int head = 0;
    private int tail = 0;

    public BlockingQueueMutex(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void enqueue(T item) throws InterruptedException {
        synchronized (this) {
            while (size == capacity) {
                wait();
            }
            array[tail++] = item;
            tail %= capacity;
            size++;
            notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        synchronized (this) {
            while (size == 0) {
                wait();
            }
            T element = array[head];
            array[head] = null;
            head = (head + 1) % capacity;
            size--;
            notifyAll();
            return element;
        }
    }

    @Override
    public int size() {
        return size;
    }
}

class BlockingQueueCondition<T> implements BlockingQueue<T> {
    private final T[] array;
    private final int capacity;
    private final ReentrantLock lock;
    private final Condition full;
    private final Condition empty;
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    public BlockingQueueCondition(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
    }

    public void enqueue(T item) throws InterruptedException {
        lock.lock();
        try {
            while (size == capacity) {
                full.await();
            }
            array[tail++] = item;
            tail %= capacity;
            size++;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                empty.await();
            }
            T element = array[head];
            array[head] = null;
            head = (head + 1) % capacity;
            size--;
            full.signal();
            return element;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }
}

class BlockingQueueSemaphore<T> implements BlockingQueue<T> {
    private final T[] array;
    private final AtomicInteger size;
    private final int capacity;
    private final CountingSemaphore producer, consumer, mutex;
    private int head = 0;
    private int tail = 0;

    public BlockingQueueSemaphore(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = new AtomicInteger(0);
        this.producer = new CountingSemaphore(capacity, capacity);
        this.consumer = new CountingSemaphore(capacity, 0);
        this.mutex = new CountingSemaphore(1, 1);
    }

    public void enqueue(T item) throws InterruptedException {
        producer.acquire();
        mutex.acquire();
        array[tail++] = item;
        tail %= capacity;
        size.incrementAndGet();
        mutex.release();
        consumer.release();
    }

    public T dequeue() throws InterruptedException {
        consumer.acquire();
        mutex.acquire();
        T element = array[head];
        array[head] = null;
        head = (head + 1) % capacity;
        size.decrementAndGet();
        mutex.release();
        producer.release();
        return element;
    }

    @Override
    public int size() {
        return size.get();
    }
}
