package dev.algos.snatch.interview_problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicatesInThreeArrays {

    List<Integer> findDuplicates(int[] A, int[] B, int[] C) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length && k < C.length) {
            if (A[i] == B[j] && B[j] == C[k]) {
                result.add(A[i]);
            }
            if (A[i] < B[j] || A[i] < C[k]) {
                i++;
            } else if (B[j] < A[i] || B[j] < C[k]) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }
}
