package dev.algos.snatch.interview_problems.reversal_linked_list;

import dev.algos.snatch.data_structures.linked_list.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ReverseLinkedListTest {

    private ReverseLinkedList instance;
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        instance = new ReverseLinkedList();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
        head.next.next.next.next.next = new ListNode<>(6);
    }

    @Test
    void reverse() {
        var node = instance.reverse(head);
        assertThat(node.toString(), equalTo("6,5,4,3,2,1"));

    }

    @Test
    void reverseRecursively() {
        var node = instance.reverseRecursively(head);
        assertThat(node.toString(), equalTo("6,5,4,3,2,1"));

    }
}
