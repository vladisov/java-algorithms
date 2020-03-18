package dev.algos.snatch.interview_problems.topological_sort;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class AlienDictionaryTest {

    private AlienDictionary instance = new AlienDictionary();

    @Test
    @Disabled
    void testAlienOrder() {
//        assertThat(instance.alienOrderKhan(new String[]{
//                "wrt",
//                "wrf",
//                "er",
//                "ett",
//                "rftt"
//        }), equalTo("wertf"));
//
//        assertThat(instance.alienOrderKhan(new String[]{
//                "z",
//                "z",
//        }), equalTo("z"));
//
//        assertThat(instance.alienOrderKhan(new String[]{
//                "za",
//                "zb",
//                "ca",
//                "cb",
//        }), equalTo("zacb"));

        assertThat(instance.alienOrderKhan(new String[]{
                "vlxpwiqbsg",
                "cpwqwqcd",
        }), equalTo("zacb"));
    }
}
