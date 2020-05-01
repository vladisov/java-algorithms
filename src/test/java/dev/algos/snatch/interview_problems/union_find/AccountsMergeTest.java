package dev.algos.snatch.interview_problems.union_find;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class AccountsMergeTest {

    @Test
    void test() {
        AccountsMerge instance = new AccountsMerge();
        List<List<String>> accounts = List.of(List.of("John", "johnsmith@mail.com", "john00@mail.com"), List.of("John", "johnnybravo@mail.com"), List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"), List.of("Mary", "mary@mail.com"));
        List<List<String>> result = instance.accountsMerge(accounts);
        assertThat(result.toString(), equalTo("[[John, johnnybravo@mail.com], [John, john00@mail.com, john_newyork@mail.com, johnsmith@mail.com], [Mary, mary@mail.com]]"));
        List<List<String>> resultDfs = instance.accountsMergeDFS(accounts);
        assertThat(resultDfs.toString(), equalTo("[[John, johnnybravo@mail.com], [John, john00@mail.com, john_newyork@mail.com, johnsmith@mail.com], [Mary, mary@mail.com]]"));
    }
}
