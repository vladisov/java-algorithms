package dev.algos.snatch.interview_problems.reversal_linked_list;

import dev.algos.snatch.data_structures.linked_list.ListNode;
import dev.algos.snatch.interview_problems.linked_list.ReverseNodesInKGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class ReverseNodesInKGroupTest {

    private ReverseNodesInKGroup instance;
    private ListNode head;

    @BeforeEach
    void setUp() {
        instance = new ReverseNodesInKGroup();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
    }

    @Test
    void testReversal() {
        assertThat(instance.reverseKGroup(head, 2).toString(), equalTo("2,1,4,3,5"));
    }
}
