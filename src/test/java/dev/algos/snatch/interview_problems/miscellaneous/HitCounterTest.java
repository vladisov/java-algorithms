package dev.algos.snatch.interview_problems.miscellaneous;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class HitCounterTest {

    private HitCounter hitCounterSet = new HitCounterSet();
    private HitCounter hitCounterArray = new HitCounterQueue();
    private HitCounter hitCounterMap = new HitCounterMap();

    @Test
    void testBaseCase() {
        hitCounterSet.hit(1);
        hitCounterSet.hit(1);
        hitCounterSet.hit(1);
        hitCounterSet.hit(300);
        assertThat(hitCounterSet.getHits(300), equalTo(4));
        hitCounterSet.hit(300);
        assertThat(hitCounterSet.getHits(300), equalTo(5));
        hitCounterSet.hit(301);
        assertThat(hitCounterSet.getHits(301), equalTo(3));
        assertThat(hitCounterSet.getHits(600), equalTo(1));

        hitCounterArray.hit(1);
        hitCounterArray.hit(1);
        hitCounterArray.hit(1);
        hitCounterArray.hit(300);
        assertThat(hitCounterArray.getHits(300), equalTo(4));
        hitCounterArray.hit(300);
        assertThat(hitCounterArray.getHits(300), equalTo(5));
        hitCounterArray.hit(301);
        assertThat(hitCounterArray.getHits(301), equalTo(3));
        assertThat(hitCounterArray.getHits(600), equalTo(1));

        hitCounterMap.hit(1);
        hitCounterMap.hit(1);
        hitCounterMap.hit(1);
        hitCounterMap.hit(300);
        assertThat(hitCounterMap.getHits(300), equalTo(4));
        hitCounterMap.hit(300);
        assertThat(hitCounterMap.getHits(300), equalTo(5));
        hitCounterMap.hit(301);
        assertThat(hitCounterMap.getHits(301), equalTo(3));
        assertThat(hitCounterMap.getHits(600), equalTo(1));
    }
}
