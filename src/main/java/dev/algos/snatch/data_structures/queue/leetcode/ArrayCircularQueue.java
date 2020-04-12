package dev.algos.snatch.data_structures.queue.leetcode;

/**
 * Design your implementation of the circular queue.
 * LeetCode: <a href="https://leetcode.com/problems/design-circular-queue/">622. Design Circular Queue</a>
 */
class ArrayCircularQueue {

    private int[] queue;
    //size of the array
    private int capacity;
    //indice of head elements in the array
    private int headIndex;
    // length of the queue
    private int count;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public ArrayCircularQueue(int k) {
        this.queue = new int[k];
        this.capacity = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[(headIndex + count) % capacity] = value;
        count++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) return false;
        headIndex = (headIndex + 1) % capacity;
        count--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int front() {
        if (isEmpty()) return -1;
        return queue[headIndex];
    }

    /**
     * Get the last item from the queue.
     */
    public int rear() {
        if (isEmpty()) return -1;
        return queue[tailIndex()];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return count == capacity;
    }

    private int tailIndex() {
        return (headIndex + count - 1) % capacity;
    }
}
