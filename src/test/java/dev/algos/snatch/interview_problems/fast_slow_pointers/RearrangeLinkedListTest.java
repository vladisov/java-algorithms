package dev.algos.snatch.interview_problems.fast_slow_pointers;

import dev.algos.snatch.data_structures.linked_list.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class RearrangeLinkedListTest {

    private RearrangeLinkedList<Integer> instance;
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        instance = new RearrangeLinkedList<>();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode<>(6);
    }

    @Test
    void testReorderEven() {
        instance.reorder(head);
        assertThat(head.toString(), equalTo("1,6,2,5,3,4"));
    }

    @Test
    void testReorderOdd() {
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        instance.reorder(head);
        assertThat(head.toString(), equalTo("1,5,2,4,3"));
    }
}
