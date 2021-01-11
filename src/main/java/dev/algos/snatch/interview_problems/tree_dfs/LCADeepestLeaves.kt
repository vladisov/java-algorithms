package dev.algos.snatch.interview_problems.tree_dfs

import dev.algos.snatch.interview_problems.helpers.TreeNode
import kotlin.math.max

/**
 * Time O(N)
 * Space O(N)
 */
fun lcaDeepestLeaves(root: TreeNode?): TreeNode? {
    val depthMap = mutableMapOf<Int, MutableSet<Int>>()
    val max = buildDepth(root, 0, depthMap)
    return lca(root, depthMap[max]!!)
}

fun buildDepth(root: TreeNode?, depth: Int, depthMap: MutableMap<Int, MutableSet<Int>>): Int {
    if (root == null) return depth
    depthMap.computeIfAbsent(depth + 1) { mutableSetOf() }.add(root.`val`)
    val left = buildDepth(root.left, depth + 1, depthMap)
    val right = buildDepth(root.right, depth + 1, depthMap)
    return max(left, right)
}

fun lca(root: TreeNode?, set: Set<Int>): TreeNode? {
    if (root == null) return null
    if (set.contains(root.`val`)) {
        return root
    }
    val left = lca(root.left, set)
    val right = lca(root.right, set)
    if (left != null && right != null) return root
    return left ?: right
}
