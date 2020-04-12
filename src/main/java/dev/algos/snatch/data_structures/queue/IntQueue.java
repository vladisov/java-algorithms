package dev.algos.snatch.data_structures.queue;

public class IntQueue {

    private int[] arr;
    private int size;
    private int front, end;


    public IntQueue(int maxSize) {
        this.size = maxSize + 1;
        arr = new int[size];
    }

    /**
     * Add an element to the queue
     *
     * @param value to add
     */
    public void enqueue(int value) {
        arr[end++] = value;
        if (end == size) {
            end = 0;
        }
        if (end == front) {
            throw new RuntimeException("Queue is too small.");
        }
    }

    /**
     * Poll an element from the front
     *
     * @return element
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        var value = arr[front++];
        if (front == size) {
            front = 0;
        }
        return value;
    }

    public int peek() {
        return arr[front];
    }


    public boolean isEmpty() {
        return front == end;
    }

    /**
     * Return the number of elements inside the queue
     *
     * @return size of the queue
     */
    public int size() {
        if (front > end) {
            return end + size - front;
        }
        return end - front;
    }
}
