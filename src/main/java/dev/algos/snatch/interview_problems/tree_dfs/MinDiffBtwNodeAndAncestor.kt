package dev.algos.snatch.interview_problems.tree_dfs

import dev.algos.snatch.interview_problems.helpers.TreeNode
import kotlin.math.max
import kotlin.math.min

class MinDiffBtwNodeAndAncestor {

    fun maxAncestorDiff(root: TreeNode?): Int {
        return helper(root, root!!.`val`, root.`val`)
    }

    fun helper(root: TreeNode?, _max: Int, _min: Int): Int {
        if (root == null) return _max - _min
        val max = max(_max, root.`val`)
        val min = min(_min, root.`val`)
        return max(helper(root.left, max, min), helper(root.right, max, min))
    }
}
