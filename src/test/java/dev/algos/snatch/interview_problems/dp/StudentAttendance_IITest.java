package dev.algos.snatch.interview_problems.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentAttendance_IITest {

    @Test
    void test() {
        var instance = new StudentAttendance_II();
        assertEquals(8, instance.checkRecord(2));
        assertEquals(8, instance.checkRecordBottomUp(2));
        assertEquals(8, instance.checkRecordBottomUpOptimized(2));
        assertEquals(19, instance.checkRecord(3));
        assertEquals(19, instance.checkRecordBottomUp(3));
        assertEquals(19, instance.checkRecordBottomUpOptimized(3));
        assertEquals(250434094, instance.checkRecord(1000));
        assertEquals(250434094, instance.checkRecordBottomUp(1000));
        assertEquals(250434094, instance.checkRecordBottomUpOptimized(1000));
    }
}
