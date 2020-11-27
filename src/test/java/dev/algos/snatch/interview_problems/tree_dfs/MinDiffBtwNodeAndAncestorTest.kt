package dev.algos.snatch.interview_problems.tree_dfs

import dev.algos.snatch.interview_problems.helpers.TreeNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MinDiffBtwNodeAndAncestorTest {

    @Test
    fun test() {
        val mdb = MinDiffBtwNodeAndAncestor()
        val treeNode = TreeNode.parseFromLevelOrder("[8,3,10,1,6,null,14,null,null,4,7,13]")
        assertEquals(7, mdb.maxAncestorDiff(treeNode))
    }
}
