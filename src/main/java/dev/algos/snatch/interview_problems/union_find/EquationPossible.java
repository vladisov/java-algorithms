package dev.algos.snatch.interview_problems.union_find;

import dev.algos.snatch.interview_problems.helpers.UnionFind;

/**
 * https://leetcode.com/problems/satisfiability-of-equality-equations
 */
public class EquationPossible {

    /**
     * Time O(Nlog26)
     * Space O(26)
     */
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String eq : equations) {
            int i = eq.charAt(0) - 'a';
            int j = eq.charAt(3) - 'a';
            boolean equals = eq.charAt(1) == '=';
            if (equals) {
                uf.union(i, j);
            }
        }
        for (String eq : equations) {
            int i = eq.charAt(0) - 'a';
            int j = eq.charAt(3) - 'a';
            boolean equals = eq.charAt(1) == '=';
            if (!equals) {
                if (uf.root(i) == uf.root(j)) return false;
            }
        }
        return true;
    }
}
