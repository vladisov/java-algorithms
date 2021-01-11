package dev.algos.snatch.interview_problems.tree_dfs

import dev.algos.snatch.interview_problems.helpers.TreeNode
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class LCADeepestLeavesKtTest {

    @Test
    fun lcaDeepestLeaves() {
        val tree = TreeNode.parseFromLevelOrder("[3,5,1,6,2,0,8,null,null,7,4]")
        assertEquals(2, lcaDeepestLeaves(tree)!!.`val`)
    }
}
