package dev.algos.snatch.interview_problems.dp.longest_palindromic_substring;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class MinimumDeletionsStringToMakeItPalindromeTest {

    @Test
    void test() {
        MinimumDeletionsStringToMakeItPalindrome mds = new MinimumDeletionsStringToMakeItPalindrome();

        assertThat(mds.minDeletions("cddpd"), equalTo(2));
        assertThat(mds.minDeletions("aaa"), equalTo(0));
        assertThat(mds.minDeletions("pqr"), equalTo(2));
        assertThat(mds.minDeletions("abdbca"), equalTo(1));
    }
}
