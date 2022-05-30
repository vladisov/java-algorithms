package dev.algos.snatch.interview_problems.ds_design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthenticationManagerTest {

    @Test
    void test() {
        var instance = new AuthenticationManager(5);
        instance.generate("aaa", 2);
        assertEquals(1, instance.countUnexpiredTokens(6));
    }
}
