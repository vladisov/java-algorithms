package dev.algos.snatch.interview_problems.array;

public class ArrayList<E> {
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
            grow();
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

    private void grow() {
        int newSize = (this.data.length * 3) / 2 + 1;
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < this.data.length; i++) {
            newArray[i] = this.data[i];
        }
        this.data = newArray;
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
}
