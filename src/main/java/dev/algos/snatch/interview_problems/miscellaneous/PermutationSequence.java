package dev.algos.snatch.interview_problems.miscellaneous;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note:
 * <p>
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * Example 1:
 * <p>
 * Input: n = 3, k = 3
 * Output: "213"
 * Example 2:
 * <p>
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {

    /**
     * Time O(N)
     * Space O(N)
     */
    public String getPermutation(int n, int k) {
        int factorial = 1;
        for (int i = 1; i < n; i++) {
            factorial *= i;
        }
        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            int range = k % factorial == 0 ? k / factorial - 1 : k / factorial;
            k = k <= factorial ? k : k - factorial * range;
            for (int j = 1; j <= n; j++) {
                if (!visited[j]) {
                    if (range == 0) {
                        sb.append(j);
                        visited[j] = true;
                        break;
                    }
                    range--;
                }
            }
            if (n - i - 1 != 0) {
                factorial /= n - i - 1;
            }
        }
        return sb.toString();
    }
}
