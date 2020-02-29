package dev.algos.snatch.interview_problems.miscellaneous;

public class MinScoreTriangulation {

    public int minScoreTriangulation(int[] A) {
        if (A.length < 3) return 0;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            int sum = findTriangleSums(A, i);
            min = Math.min(min, sum);
        }

        return min;
    }

    int findTriangleSums(int[] A, int root) {
        int product = 0;
        for (int i = 0; i < A.length; i++) {
            //removed all neighbors
            if (root == i) continue;
            if (root == 0) {
                if (i == root + 1 || i == A.length - 1) continue;
            }
            if (root == A.length - 1) {
                if (i == 0 || i == root - 1) continue;
            } else {
                if (i == root - 1 || i == root + 1) continue;
            }

            for (int j = 0; j < A.length; j++) {
                if (j == i || j == root) continue;
                int curr = A[i] * A[j] * A[root];
                if (product == 0) {
                    product = curr;
                } else {
                    product *= curr;
                }
            }
        }
        return product;
    }
}
