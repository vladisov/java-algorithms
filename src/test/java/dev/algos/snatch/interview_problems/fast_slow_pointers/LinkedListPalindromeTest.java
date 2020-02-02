package dev.algos.snatch.interview_problems.fast_slow_pointers;

import dev.algos.snatch.data_structures.linked_list.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class LinkedListPalindromeTest {
    private LinkedListPalindrome instance;
    private ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        instance = new LinkedListPalindrome();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(2);
        head.next.next.next.next = new ListNode<>(1);
    }

    @Test
    void testPalindromeSuccess() {
        boolean result = instance.isPalindrome(head);
        assertThat(result, equalTo(true));
    }

    @Test
    void testPalindromeFalse() {
        head.next.next.next.next = new ListNode<>(11);
        boolean result = instance.isPalindrome(head);
        assertThat(result, equalTo(false));
    }

    @Test
    void testPalindromeFalse2() {
        head = new ListNode<>(1);
        head.next = new ListNode<>(1);
        head.next.next = new ListNode<>(2);
        head.next.next.next = new ListNode<>(1);
        boolean result = instance.isPalindrome(head);
        assertThat(result, equalTo(false));
    }
}
