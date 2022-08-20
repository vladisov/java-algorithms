# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode],
                      list2: Optional[ListNode]) -> Optional[ListNode]:
        h1 = list1
        h2 = list2
        head = ListNode(0)
        curr = head
        while h1 is not None and h2 is not None:
            if h1.val < h2.val:
                curr.next = h1
                h1 = h1.next
            else:
                curr.next = h2
                h2 = h2.next
            curr = curr.next
        while h1 is not None:
            curr.next = h1
            h1 = h1.next
            curr = curr.next
        while h2 is not None:
            curr.next = h2
            h2 = h2.next
            curr = curr.next
        return head.next
