package dev.algos.snatch.interview_problems.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NQueensTest {

    @Test
    void test() {
        NQueens nq = new NQueens();
        assertEquals("[[.Q.., ...Q, Q..., ..Q.], [..Q., Q..., ...Q, .Q..]]", nq.solveNQueens(4).toString());
        assertEquals("[[.Q...., ...Q.., .....Q, Q....., ..Q..., ....Q.], [..Q..., .....Q, .Q...., ....Q., Q....., ...Q..], [...Q.., Q....., ....Q., .Q...., .....Q, ..Q...], [....Q., ..Q..., Q....., .....Q, ...Q.., .Q....]]", nq.solveNQueens(6).toString());
    }
}
