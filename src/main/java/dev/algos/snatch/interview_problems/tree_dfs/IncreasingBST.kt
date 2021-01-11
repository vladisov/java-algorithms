package dev.algos.snatch.interview_problems.tree_dfs

import dev.algos.snatch.interview_problems.helpers.TreeNode
import java.util.Stack

/**
 * Time O(N)
 * Space O(H)
 */
fun increasingBSTIterative(_root: TreeNode?): TreeNode? {
    var curr = _root
    val stack = Stack<TreeNode>()
    val head = TreeNode(0)
    var prev = head
    while (!stack.isEmpty() || curr != null) {
        while (curr != null) {
            stack.add(curr)
            curr = curr.left
        }
        curr = stack.pop()
        prev.right = curr
        curr.left = null
        prev = curr
        curr = curr.right
    }
    return head.right
}

var prev = TreeNode(0)
val head = prev
fun increasingBST(root: TreeNode?): TreeNode? {
    if (root == null) return null
    increasingBST(root.left)
    prev.right = root
    prev.left = null
    prev = prev.right
    increasingBST(root.right)
    prev.left = null
    return head.right
}
