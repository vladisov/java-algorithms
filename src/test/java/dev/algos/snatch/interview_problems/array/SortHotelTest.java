package dev.algos.snatch.interview_problems.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class SortHotelTest {

    @Test
    void testSort() {
        SortHotel instance = new SortHotel();

        List<Integer> result = instance.sortHotels(
                "breakfast beach citycenter location metro view staff price\n" +
                        "5\n" +
                        "1\n" +
                        "This hotel has a nice view of the citycenter. The location is perfect.\n" +
                        "2\n" +
                        "The breakfast is ok. Regarding the location, it is quite far from citycenter but price is cheap so it is worth.\n" +
                        "1\n" +
                        "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.\n" +
                        "1\n" +
                        "They said I could't take my dog and there were other guests with dogs! That is not fair!\n" +
                        "2\n" +
                        "Very friendly staff and goof cost-benefit ratio. Its location is a bit far from citycenter.");

        assertThat(result, hasSize(2));
        assertThat(result.toString(), equalTo("[2, 1]"));
    }
}
