package dev.algos.snatch.interview_problems.reversal_linked_list;

import dev.algos.snatch.data_structures.linked_list.ListNode;
import dev.algos.snatch.interview_problems.linked_list.RotateLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class RotateLinkedListTest {

    private RotateLinkedList instance;
    private ListNode head;

    @BeforeEach
    void setUp() {
        instance = new RotateLinkedList();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
    }

    @Test
    void rotateTest() {
        ListNode rotated = instance.rotate(head, 8);
        assertThat(rotated.toString(), equalTo("3,4,5,1,2"));
    }

}
