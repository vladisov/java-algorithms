package dev.algos.snatch.interview_problems.greedy;

public class MinDominoRotations {

    public int minDominoRotations(int[] A, int[] B) {
        if (A.length == 0) return 0;
        int a = 0, b = 0, n = A.length;

        int x = A[0];
        for (int i = 0; i < n; i++) {
            if (A[i] != x && B[i] != x) {
                a = -1;
                break;
            }
            if (A[i] != x) a++;
            if (B[i] != x) b++;
        }
        int rotations = Math.min(a, b);

        a = 0;
        b = 0;
        x = B[0];
        for (int i = 0; i < n; i++) {
            if (A[i] != x && B[i] != x) {
                a = -1;
                break;
            }
            if (A[i] != x) a++;
            if (B[i] != x) b++;
        }
        if (rotations == -1) {
            return Math.min(a, b);
        } else if (a == -1) {
            return rotations;
        }
        return Math.min(rotations, a);
    }
}
