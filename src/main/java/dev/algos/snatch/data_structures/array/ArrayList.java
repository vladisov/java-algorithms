package dev.algos.snatch.data_structures.array;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author vladov 2019-12-03
 */
public class ArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;

    public ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elementData = new Object[initialCapacity];
            this.size = 0;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);
        return elementData(index);
    }

    public ArrayList<T> add(T element) {
        if (size >= elementData.length) {
            this.elementData = grow();
        }
        elementData[size++] = element;
        return this;
    }

    public T delete(int index) {
        checkIndex(index);
        T el = elementData(index);
        if (index == size - 1) {
            elementData[--size] = null;
        } else {
            elementData[index] = null;
            shrink(index);
        }
        return el;
    }


    public T set(int index, T el) {
        checkIndex(index);
        T oldValue = elementData(index);
        elementData[index] = el;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    private T elementData(int index) {
        return (T) elementData[index];
    }

    private Object[] grow() {
        int newSize = elementData.length * 2;
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < elementData.length; i++) {
            newArray[i] = elementData[i];
        }
        return newArray;
    }

    private void shrink(int index) {
        for (int i = index + 1; i < size; i++) {
            elementData[i - 1] = elementData[i];
        }
        elementData[--size] = null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        return sb.append("]")
                .toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    private class ListIterator implements Iterator<T> {
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            checkIndex(cursor);
            return elementData(cursor++);
        }

        @Override
        public void remove() {
            checkIndex(cursor);
            delete(cursor);
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            //TODO
        }
    }
}
