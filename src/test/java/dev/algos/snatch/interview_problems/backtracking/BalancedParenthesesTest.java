package dev.algos.snatch.interview_problems.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class BalancedParenthesesTest {

    private BalancedParentheses instance = new BalancedParentheses();

    @Test
    void testGenerateDfs() {
        List<String> result = instance.generateParenthesis(3);
        assertThat(result.toString(), equalTo("[((())), (()()), (())(), ()(()), ()()()]"));
    }

    @Test
    void testGenerateBfs() {
        List<String> result = instance.generateParenthesisBfs(3);
        assertThat(result.toString(), equalTo("[((())), (()()), (())(), ()(()), ()()()]"));
    }
}
