package dev.algos.snatch.interview_problems.array;

/**
 * @author vladov 2019-12-01
 */
class ExampleProblem {

    /**
     * Some problem definition like
     * find element in array etc.
     * <p>
     * Time complexity:
     * O(n)
     * Space complexity:
     * O(1)
     */
    int exampleProblem(int[] arr, int j) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == j) {
                return i;
            }
        }
        return -1;
    }
}
