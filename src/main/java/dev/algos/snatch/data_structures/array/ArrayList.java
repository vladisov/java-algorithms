package dev.algos.snatch.data_structures.array;

/**
 * @author vladov 2019-12-03
 */
public class ArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] array;

    public ArrayList() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    public ArrayList<T> add(T element) {
        if (size >= array.length) {
            grow();
        }
        array[size++] = element;
        return this;
    }

    public T delete(int index) {
        if (index == size - 1) {
            @SuppressWarnings("unchecked") T el = (T) array[index];
            array[--size] = null;
            return el;
        }
        if (index >= 0 && index < size - 1) {
            @SuppressWarnings("unchecked") T el = (T) array[index];
            array[index] = null;
            shrink(index);
            return el;
        }
        throw new IndexOutOfBoundsException(index);
    }

    private void grow() {
        int newSize = array.length * 2;
        Object[] newArray = new Object[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    private void shrink(int index) {
        if (!checkIndex(index)) return;
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        array[--size] = null;
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        return sb.append("]")
                .toString();
    }
}
