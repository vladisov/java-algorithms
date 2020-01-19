package dev.algos.snatch.data_structures.array;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author vladov 2019-12-03
 */
class ArrayListTest {

    @Test
    void testInitialization() {
        ArrayList<Integer> list = new ArrayList<>();
        assertThat(list, notNullValue());
    }

    @Test
    void testAddAndGet() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertThat(list.size(), equalTo(10));
        assertThat(list.get(0), equalTo(0));
        assertThat(list.get(9), equalTo(9));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        assertThat(list.size(), equalTo(30));
        assertThat(list.get(10), equalTo(0));
        assertThat(list.get(29), equalTo(19));
    }

    @Test
    void testDelete() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Integer old = list.delete(9);
        assertThat(list.size(), equalTo(9));
        assertThat(old, equalTo(9));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(9));

        old = list.delete(3);
        assertThat(list.size(), equalTo(8));
        assertThat(old, equalTo(3));
        assertThat(list.get(3), equalTo(4));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(8));
    }

    @Test
    void testSetSuccess() {
        ArrayList<String> list = new ArrayList<>(5);
        for (int i = 0; i < 10; i++) {
            list.add(i + "s");
        }
        list.set(0, "1s");
        assertThat(list.get(0), equalTo("1s"));
    }

    @Test
    void testSetIncorrectIndex() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "s");
        }
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(10, "1s"));
    }

    @Test
    void testToString() {
        ArrayList<Integer> list = new ArrayList<>();
        assertThat(list.toString(), equalTo("[]"));

        list.add(1)
                .add(2)
                .add(3);
        assertThat(list.toString(), equalTo("[1,2,3]"));
    }

    @Test
    void testIteratorNextSuccess() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i + "s");
        }

        Iterator<String> iterator = list.iterator();
        assertThat(iterator, notNullValue());
        assertThat(iterator.hasNext(), equalTo(true));

        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        assertThat(sb.toString(), equalTo("0s1s2s3s4s"));
    }

    @Test
    void testIteratorRemoveSuccess() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i + "s");
        }

        Iterator<String> iterator = list.iterator();
        assertThat(iterator, notNullValue());
        assertThat(iterator.hasNext(), equalTo(true));

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (iterator.hasNext()) {
            if (i == 2) {
                iterator.remove();
            }
            i++;
            sb.append(iterator.next());
        }
        assertThat(sb.toString(), equalTo("0s1s3s4s"));
    }

    @Test
    void testForeach() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i + "s");
        }

        Iterator<String> iterator = list.iterator();
        assertThat(iterator, notNullValue());
        assertThat(iterator.hasNext(), equalTo(true));

        StringBuilder sb = new StringBuilder();
        for (String el : list) {
            sb.append(el);
        }
        assertThat(sb.toString(), equalTo("0s1s2s3s4s"));
    }

    @Test
    void testIteratorRemoveLastSuccess() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i + "s");
        }

        Iterator<String> iterator = list.iterator();
        assertThat(iterator, notNullValue());
        assertThat(iterator.hasNext(), equalTo(true));

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (iterator.hasNext()) {
            if (i == 4) {
                iterator.remove();
            } else {
                sb.append(iterator.next());
            }
            i++;
        }
        assertThat(sb.toString(), equalTo("0s1s2s3s"));
    }
}