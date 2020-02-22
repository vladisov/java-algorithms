package dev.algos.snatch.interview_problems.heap;

import dev.algos.snatch.data_structures.linked_list.ListNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MergeKSortedListsTest {

    private MergeKSortedLists instance = new MergeKSortedLists();

    @Test
    void testMerge() {
        /*
         *   1->4->5,
         *   1->3->4,
         *   2->6
         */
        ListNode<Integer> first = new ListNode<>(1);
        first.next = new ListNode<>(4);
        first.next.next = new ListNode<>(5);

        ListNode<Integer> sec = new ListNode<>(1);
        sec.next = new ListNode<>(3);
        sec.next.next = new ListNode<>(4);

        ListNode<Integer> third = new ListNode<>(2);
        third.next = new ListNode<>(6);

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = first;
        listNodes[1] = sec;
        listNodes[2] = third;

        ListNode result = instance.mergeKLists(listNodes);

        result.toString();
        assertThat(result.toString(), equalTo("1,1,2,3,4,4,5,6"));
    }

}
