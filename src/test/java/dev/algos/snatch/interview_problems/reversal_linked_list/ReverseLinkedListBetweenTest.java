package dev.algos.snatch.interview_problems.reversal_linked_list;

import dev.algos.snatch.data_structures.linked_list.ListNode;
import dev.algos.snatch.interview_problems.linked_list.ReverseLinkedListBetween;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Disabled
class ReverseLinkedListBetweenTest {

    private ReverseLinkedListBetween instance;
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        instance = new ReverseLinkedListBetween();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
        head.next.next.next.next = new ListNode<>(5);
    }

    @Test
    void reverse() {
        var node = instance.reverse(head, 2, 4);
        assertThat(node.toString(), equalTo("1,4,3,2,5"));
    }

    @Test
    void reverse1() {
        var node = instance.reverse(head, 2, 5);
        assertThat(node.toString(), equalTo("1,5,4,3,2"));
    }
}
