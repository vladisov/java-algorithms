package dev.algos.snatch.data_structures.array;

import org.junit.jupiter.api.Test;

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
    void testToString() {
        ArrayList<Integer> list = new ArrayList<>();
        assertThat(list.toString(), equalTo("[]"));

        list.add(1)
                .add(2)
                .add(3);
        assertThat(list.toString(), equalTo("[1,2,3]"));
    }
}