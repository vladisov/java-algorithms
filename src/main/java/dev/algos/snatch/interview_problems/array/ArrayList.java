package dev.algos.snatch.interview_problems.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] data;

    public ArrayList(final int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        if (initialCapacity == 0) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            this.data = new Object[initialCapacity];
        }
    }

    public ArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
    }

    public boolean add(E element) {
        if (this.size == this.data.length) {
            resize((this.data.length * 3) / 2 + 1);
        }
        this.data[size++] = element;
        return true;
    }

    public E remove(int index) {
        validate(index);
        E oldValue = (E) this.data[index];
        if (index == this.size - 1) {
            this.data[--size] = null;
        } else {
            for (int i = index + 1; i < this.size; i++) {
                this.data[i - 1] = this.data[i];
            }
            this.data[--size] = null;
        }
        if (this.size > 0 && this.size == this.data.length / 4) {
            resize(this.data.length / 2);
        }
        return oldValue;
    }

    public E get(int index) {
        validate(index);
        return (E) this.data[index];
    }

    public int size() {
        return this.size;
    }

    private void validate(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Unable to remove element at index " + index);
        }
    }

    private void resize(int capacity) {
        final Object[] copy = new Object[capacity];
        for (int i = 0; i < this.size; i++) {
            copy[i] = this.data[i];
        }
        this.data = copy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        return sb.append("]").toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    public Iterator<E> reverseIterator() {
        return new ArrayListReverseIterator();
    }

    private class ArrayListIterator implements Iterator<E> {

        private int index;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public E next() {
            if (index >= size()) {
                throw new NoSuchElementException();
            }
            return (E) data[index++];
        }
    }

    private class ArrayListReverseIterator implements Iterator<E> {

        private int index = size() - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public E next() {
            if (index < 0) {
                throw new NoSuchElementException();
            }
            return (E) data[index--];
        }
    }

}
