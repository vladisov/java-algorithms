package dev.algos.snatch.interview_problems.fast_slow_pointers;

import dev.algos.snatch.data_structures.linked_list.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MiddleOfLinkedListTest {
    private MiddleOfLinkedList instance;
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        instance = new MiddleOfLinkedList();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
    }

    @Test
    void findMiddleOdd() {
        assertThat(instance.findMiddle(head), equalTo(head.next.next));
    }

    @Test
    void findMiddleEven() {
        head.next.next.next.next.next = new ListNode<>(6);
        assertThat(instance.findMiddle(head), equalTo(head.next.next.next));
    }
}
