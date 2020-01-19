package dev.algos.snatch.interview_problems.array.two_pointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array with positive numbers and a target number,
 * find all of its contiguous subArrays whose product is less than the target number.
 */
class SubarrayProductLessThanK {

    List<List<Integer>> findSubArrays(int[] arr, int target) {
        List<List<Integer>> subArrays = new ArrayList<>();
        int product = 1;
        int left = 0;
        for (int i = 0; i < arr.length; i++) {
            product *= arr[i];

            while (product >= target) {
                product /= arr[left++];
            }

            List<Integer> tmp = new LinkedList<>();
            for (int j = i; j >= left; j--) {
                tmp.add(0, arr[j]);
                subArrays.add(new ArrayList<>(tmp));
            }
        }
        return subArrays;
    }
}
