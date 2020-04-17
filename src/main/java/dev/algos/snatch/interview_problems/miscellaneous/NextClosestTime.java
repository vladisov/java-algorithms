package dev.algos.snatch.interview_problems.miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextClosestTime {

    /**
     * Time O(N)
     * Space O(N)
     */
    public String nextClosestTime(String time) {
        Set<Integer> nums = new HashSet<>();
        int start = Integer.parseInt(time.substring(0, 2)) * 60 +
                Integer.parseInt(time.substring(3)); //start time  1174
        int upperBound = 1440;
        for (int i = 0; i < time.length(); i++) {
            if (i != 2) {
                nums.add(time.charAt(i) - '0');
            }
        }
        List<Integer> hours = new ArrayList<>();
        List<Integer> minutes = new ArrayList<>();
        //permutations with size 4
        for (int num : nums) {
            for (int num1 : nums) {
                int hour = Integer.parseInt("" + num + num1);
                if (hour < 24) {
                    hours.add(hour);
                }
                int minute = Integer.parseInt("" + num + num1);
                if (minute < 60) {
                    minutes.add(minute);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int minAfter = Integer.MAX_VALUE;
        for (int hour : hours) {
            for (int minute : minutes) {
                int val = hour * 60 + minute;
                min = Math.min(min, val);
                if (val > start && val <= upperBound) {
                    minAfter = Math.min(minAfter, val);
                }
            }
        }
        int ans = minAfter == Integer.MAX_VALUE ? min : minAfter;
        return String.format("%02d:%02d", ans / 60, ans % 60);
    }

}
