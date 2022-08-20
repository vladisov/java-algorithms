# Definition for a binary tree node.

from typing import Dict, Optional, Set
from main.java.dev.algos.snatch.interview_problems.helpers.Utils import TreeNode


class Solution:
    def findTarget(self, root: Optional[TreeNode], k: int) -> bool:
        def find(root: Optional[TreeNode], set: Set, k: int) -> bool:
            if not root:
                return False
            if k - root.val in set:
                return True
            set.add(root.val)
            return find(root.left, set, k) or find(root.right, set, k)
        return find(root, set(), k)
