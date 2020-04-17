package dev.algos.snatch.interview_problems.dp.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestStringChainTest {

    @Test
    void test() {
        LongestStringChain lsc = new LongestStringChain();
        assertEquals(8, lsc.longestStrChain(new String[]{"qyssedya", "pabouk", "mjwdrbqwp", "vylodpmwp", "nfyqeowa", "pu",
                "paboukc", "qssedya", "lopmw", "nfyqowa", "vlodpmw", "mwdrqwp", "opmw", "qsda", "neo", "qyssedhyac", "pmw", "lodpmw", "mjwdrqwp", "eo",
                "nfqwa", "pabuk", "nfyqwa", "qssdya", "qsdya", "qyssedhya", "pabu", "nqwa", "pabqoukc", "pbu", "mw", "vlodpmwp", "x", "xr"}));
        ;
    }
}
