package dev.algos.snatch.data_structures.linked_list;

import dev.algos.snatch.data_structures.array.ArrayList;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SinglyLinkedListTest {

    @Test
    void testInsertAtHeadOneElement() {
        var list = new SinglyLinkedList<String>();
        list.insertAtHead("dummyValue");
        assertThat(list.size(), equalTo(1));
        assertThat(list.get(0), equalTo("dummyValue"));
    }

    @Test
    void testInsertAtHeadMultipleElements() {
        var list = new SinglyLinkedList<String>();
        list.insertAtHead("dummy1");
        list.insertAtHead("dummy2");
        assertThat(list.size(), equalTo(2));
        assertThat(list.get(0), equalTo("dummy2"));
        assertThat(list.get(1), equalTo("dummy1"));
    }

    @Test
    void testInsertAtEndOneElement() {
        var list = new SinglyLinkedList<String>();
        list.insertAtEnd("dummyValue");
        assertThat(list.size(), equalTo(1));
        assertThat(list.get(0), equalTo("dummyValue"));
    }

    @Test
    void testInsertAtEndMultipleElements() {
        var list = new SinglyLinkedList<String>();
        list.insertAtEnd("dummy1");
        list.insertAtEnd("dummy2");
        assertThat(list.size(), equalTo(2));
        assertThat(list.get(0), equalTo("dummy1"));
        assertThat(list.get(1), equalTo("dummy2"));
    }

    @Test
    void testSize() {
        var list = new SinglyLinkedList<Integer>();
        Random random = new Random();
        int i = random.nextInt(1_000);
        for (int j = 0; j < i; j++) {
            list.insertAtEnd(random.nextInt());
        }
        assertThat(list.size(), equalTo(i));
    }

    @Test
    @Disabled
    void compareInsertions() {
        var list = new SinglyLinkedList<Integer>();
        Random random = new Random();
        int i = random.nextInt(1_000_000) + 1;
        long start = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            list.insertAtHead(j);
        }
        long end = System.currentTimeMillis();
        System.out.println("SinglyLinkedList 1,000,000 elements insertion at head took : " + (end - start) + " ms");
        var arrayList = new ArrayList<Integer>();
        start = System.currentTimeMillis();
        for (int j = 0; j < i; j++) {
            arrayList.add(j);
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList adding 1,000,000 elements took : " + (end - start) + " ms");
    }

    @Test
    void testRemoveByIndexSuccess() {
        var list = new SinglyLinkedList<String>();
        list.insertAtEnd("dummy1");
        list.insertAtEnd("dummy2");
        list.insertAtEnd("dummy3");
        list.insertAtEnd("dummy4");

        boolean remove = list.remove(2);
        assertThat(remove, equalTo(true));
        assertThat(list.size(), equalTo(3));
        assertThat(list.toString(), equalTo("dummy1 -> dummy2 -> dummy4"));
    }

    @Test
    void testRemoveByIndexOutOfBounds() {
        var list = new SinglyLinkedList<String>();
        list.insertAtEnd("dummy1");
        list.insertAtEnd("dummy2");
        list.insertAtEnd("dummy3");
        list.insertAtEnd("dummy4");

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    void testRemoveByValueSuccess() {
        var list = new SinglyLinkedList<String>();
        list.insertAtEnd("dummy1");
        list.insertAtEnd("dummy2");
        list.insertAtEnd("dummy3");
        list.insertAtEnd("dummy4");

        boolean remove = list.remove("dummy3");
        assertThat(remove, equalTo(true));
        assertThat(list.size(), equalTo(3));
        assertThat(list.toString(), equalTo("dummy1 -> dummy2 -> dummy4"));
    }

    @Test
    void testRemoveByValueNotFound() {
        var list = new SinglyLinkedList<String>();
        list.insertAtEnd("dummy1");
        list.insertAtEnd("dummy2");
        list.insertAtEnd("dummy3");
        list.insertAtEnd("dummy4");

        boolean remove = list.remove("dummy5");
        assertThat(remove, equalTo(false));
        assertThat(list.size(), equalTo(4));
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    void iterator(SinglyLinkedList<Integer> singlyLinkedList) {
        Iterator<Integer> iterator = singlyLinkedList.iterator();
        assertEquals(0, iterator.next());
        assertEquals(1, iterator.next());
        for (; iterator.hasNext(); ) {
            assertNotNull(iterator.next());
        }
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    static Stream<Arguments> listProvider() {
        final SinglyLinkedList<Integer> instance = new SinglyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            instance.insertAtEnd(i);
        }
        return Stream.of(arguments(instance));
    }
}
