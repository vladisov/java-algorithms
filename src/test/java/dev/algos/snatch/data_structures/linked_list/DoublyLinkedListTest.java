package dev.algos.snatch.data_structures.linked_list;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    void addFirstSuccess() {
        list.addFirst(8);
        list.addFirst(22);

        assertEquals(22, list.getFirst());
    }

    @Test
    void addLastSuccess() {
        list.addLast(8);
        list.addLast(22);
        list.addLast(86);

        assertEquals(86, list.getLast());
    }

    @Test
    void addElementSuccess() {
        //given
        list.addFirst(8);
        list.addFirst(22);
        list.addLast(18);
        list.addLast(86);

        //when
        list.add(2, 20);

        //then
        assertEquals(20, list.get(2));
        assertEquals(86, list.getLast());
        assertEquals(5, list.size());
    }

    @Test
    void insertAfterSuccess() {
        //given
        list.addFirst(8);
        list.addFirst(22);
        list.addLast(86);

        //when
        list.insertAfter(8, 19);

        //then
        assertEquals(19, list.get(2));
    }

    @Test
    void insertBeforeSuccess() {
        //given
        list.addFirst(8);
        list.addFirst(22);
        list.addLast(86);

        //when
        list.insertBefore(86, 19);

        //then
        assertEquals(19, list.get(2));
    }

    @Test
    void deleteSuccess() {
        //given
        list.addFirst(8);
        list.addFirst(22);
        list.addLast(19);
        list.addLast(86);

        //when
        list.delete(19);

        //then
        assertEquals(86, list.get(2));
        assertEquals(8, list.get(1));
        assertEquals(3, list.size());
    }

    @Test
    void deleteHeadSuccess() {
        //given
        list.addFirst(8);
        list.addFirst(22);

        //when
        list.delete(8);

        //then
        assertEquals(22, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void deleteFromTwoItemsSuccess() {
        //given
        list.addFirst(8);
        list.addFirst(22);

        //when
        list.delete(22);

        //then
        assertEquals(8, list.get(0));
        assertEquals(1, list.size());
    }

    @ParameterizedTest
    @MethodSource("listProvider")
    void iterator(DoublyLinkedList<Integer> doublyLinkedList) {
        Iterator<Integer> iterator = doublyLinkedList.iterator();
        assertEquals(0, iterator.next());
        assertEquals(1, iterator.next());
        for (; iterator.hasNext(); ) {
            assertNotNull(iterator.next());
        }
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    static Stream<Arguments> listProvider() {
        final DoublyLinkedList<Integer> instance = new DoublyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            instance.addLast(i);
        }
        return Stream.of(arguments(instance));
    }

}

