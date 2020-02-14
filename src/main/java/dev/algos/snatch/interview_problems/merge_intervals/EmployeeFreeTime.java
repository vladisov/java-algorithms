package dev.algos.snatch.interview_problems.merge_intervals;

import dev.algos.snatch.interview_problems.helpers.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * For ‘K’ employees, we are given a list of intervals representing the working hours of each employee.
 * Our goal is to find out if there is a free interval that is common to all employees.
 * You can assume that each list of employee working hours is sorted on the start time.
 * <p>
 * Example 1:
 * <p>
 * Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
 * Output: [3,5]
 * Explanation: Both the employees are free between [3,5].
 * Example 2:
 * <p>
 * Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
 * Output: [4,6], [8,9]
 * Explanation: All employess are free between [4,6] and [8,9].
 * Example 3:
 * <p>
 * Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
 * Output: [5,7]
 * Explanation: All employess are free between [5,7].
 */
public class EmployeeFreeTime {

    /**
     * Time complexity
     * Space complexity
     */
    public List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        Queue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(Interval::getStart));
        for (List<Interval> intervals : schedule) {
            queue.addAll(intervals);
        }
        List<Interval> result = new ArrayList<>();
        Interval first = queue.poll();
        int start = first.getStart();
        int end = first.getEnd();
        while (!queue.isEmpty()) {
            if (queue.peek().getStart() > end) {
                result.add(new Interval(end, queue.peek().getStart()));
                var curr = queue.poll();
                start = curr.getStart();
                end = curr.getEnd();
            } else {
                var curr = queue.poll();
                end = Math.max(end, curr.getEnd());
                start = Math.min(start, curr.getStart());
            }
        }
        return result;
    }

    public List<Interval> findEmployeeFreeTimeEducative(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        // PriorityQueue to store one interval from each employee
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.interval.getStart()));

        // insert the first interval of each employee to the queue
        for (int i = 0; i < schedule.size(); i++)
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));

        Interval previousInterval = minHeap.peek().interval;
        while (!minHeap.isEmpty()) {
            EmployeeInterval queueTop = minHeap.poll();
            // if previousInterval is not overlapping with the next interval, insert a free interval
            if (previousInterval.getEnd() < queueTop.interval.getStart()) {
                result.add(new Interval(previousInterval.getEnd(), queueTop.interval.getStart()));
                previousInterval = queueTop.interval;
            } else { // overlapping intervals, update the previousInterval if needed
                if (previousInterval.getEnd() < queueTop.interval.getEnd())
                    previousInterval = queueTop.interval;
            }

            // if there are more intervals available for the same employee, add their next interval
            List<Interval> employeeSchedule = schedule.get(queueTop.employeeIndex);
            if (employeeSchedule.size() > queueTop.intervalIndex + 1) {
                minHeap.offer(new EmployeeInterval(employeeSchedule.get(queueTop.intervalIndex + 1), queueTop.employeeIndex,
                        queueTop.intervalIndex + 1));
            }
        }

        return result;
    }

}

class EmployeeInterval {
    Interval interval; // interval representing employee's working hours
    int employeeIndex; // index of the list containing working hours of this employee
    int intervalIndex; // index of the interval in the employee list

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }
};
