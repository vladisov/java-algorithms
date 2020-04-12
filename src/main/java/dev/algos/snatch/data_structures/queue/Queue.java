package dev.algos.snatch.data_structures.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {

    private LinkedList<T> list = new LinkedList<>();

    /**
     * Peek the element from without removing the front of the queue
     *
     * @return element
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Empty");
        }
        return list.peek();
    }

    /**
     * Poll an element and remove it from the front of the queue
     *
     * @return element
     */
    public T poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Empty");
        }
        return list.poll();
    }

    /**
     * Add an element to the back of the queue
     *
     * @param element element to be added
     */
    public void offer(T element) {
        list.addLast(element);
    }


    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
