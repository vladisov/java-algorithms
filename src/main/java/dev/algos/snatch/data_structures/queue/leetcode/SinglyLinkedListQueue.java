package dev.algos.snatch.data_structures.queue.leetcode;

/**
 * Design your implementation of the circular queue.
 * LeetCode: <a href="https://leetcode.com/problems/design-circular-queue/">622. Design Circular Queue</a>
 */
public class SinglyLinkedListQueue {
    //the reference to the head element in the queue.
    private Node head;
    //the reference to the tail element in the queue.
    private Node tail;
    //the current length of the queue. This is a critical attribute that helps us to do the boundary check in each method.
    private int count;
    //the maximum number of elements that the circular queue will hold.
    //Unlike the Array approach, we need to explicitly keep the reference to the tail element. Without this attribute, it would take us O(N) time complexity to locate the tail element from the head element.
    private int capacity;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public SinglyLinkedListQueue(int k) {
        this.capacity = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        var newNode = new Node(value);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        count++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) return false;
        head = head.next;
        count--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int front() {
        if (isEmpty()) return -1;
        return head.val;
    }

    /**
     * Get the last item from the queue.
     */
    public int rear() {
        if (isEmpty()) return -1;
        return tail.val;
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
}

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
