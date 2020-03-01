package dev.algos.snatch.interview_problems.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class EvaluateExpressionTest {

    @Test
    void diffWaysToCompute() {
        EvaluateExpression instance = new EvaluateExpression();
        List<Integer> result = instance.diffWaysToCompute("2*3-4-5");
        assertThat(result.toString(), equalTo("[8, -12, 7, -7, -3]"));
    }
}
