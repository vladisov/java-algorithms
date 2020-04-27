package dev.algos.snatch.interview_problems.fast_slow_pointers;

import dev.algos.snatch.data_structures.linked_list.ListNode;
import dev.algos.snatch.interview_problems.helpers.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SortedListToBSTTest {

    SortedListToBST slb;
    ListNode<Integer> head;

    @BeforeEach
    void setUp() {
        slb = new SortedListToBST();
        head = new ListNode<>(1);
        head.next = new ListNode<>(2);
        head.next.next = new ListNode<>(3);
        head.next.next.next = new ListNode<>(4);
    }

    @Test
    void test() {
        TreeNode treeNode = slb.sortedListToBST(head);
        assertThat(treeNode.toStringLevelOrder(), equalTo("[3,1,4,null,2,null,null]"));
        SortedListToBST.Solution solution = new SortedListToBST.Solution();
        assertThat(solution.sortedListToBST(head).toStringLevelOrder(), equalTo("[2,1,3,null,null,null,4]"));
    }
}
