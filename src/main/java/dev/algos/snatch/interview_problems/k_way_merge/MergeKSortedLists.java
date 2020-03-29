package dev.algos.snatch.interview_problems.k_way_merge;

import dev.algos.snatch.data_structures.linked_list.ListNode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {

    /**
     * Time complexity ONlogK where K - number of lists and N - number of elements in total
     * Space complexity O(k) for storing K elements in priority queue
     */
    public ListNode<Integer> mergeKLists(ListNode<Integer>[] lists) {
        PriorityQueue<ListNode<Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(l -> l.value));
        Collections.addAll(queue, lists);
        var dummyNode = new ListNode<>(0);
        var curr = dummyNode;
        while (!queue.isEmpty()) {
            var node = queue.poll();
            curr.next = node;
            if (node.next != null)
                queue.add(node.next);
            curr = curr.next;
        }
        return dummyNode.next;
    }
}
