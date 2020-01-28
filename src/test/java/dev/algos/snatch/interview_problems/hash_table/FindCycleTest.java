package dev.algos.snatch.interview_problems.hash_table;

import dev.algos.snatch.data_structures.linked_list.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

class FindCycleTest {

    private FindCycle instance;
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        instance = new FindCycle();

        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode<>(6);
    }

    @Test
    void findCycleNotFound() {
        ListNode cycle = instance.findCycle(head);
        assertThat(cycle, nullValue());
    }

    @Test
    void findCycleExists() {
        head.next.next.next.next.next.next = head.next.next;
        ListNode cycle = instance.findCycle(head);
        assertThat(cycle, is(head.next.next));
    }

    @Test
    void findCycleExists2() {
        head.next.next.next.next.next.next = head.next.next.next;
        ListNode cycle = instance.findCycle(head);
        assertThat(cycle, is(head.next.next.next));
    }

}
