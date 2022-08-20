from typing import List
from collections import defaultdict

# Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
# i - k <= r <= i + k,
# j - k <= c <= j + k, and
# (r, c) is a valid position in the matrix.
# Example 1:

# Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
# Output: [[12,21,16],[27,45,33],[24,39,28]]
# Example 2:

# Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
# Output: [[45,45,45],[45,45,45],[45,45,45]]
# https://leetcode.com/problems/matrix-block-sum/



class Solution:
    def matrixBlockSum(self, mat: List[List[int]], k: int) -> List[List[int]]:
        n, m = len(mat), len(mat[0])
        dp = [[0] * (m + 1) for _ in range(n + 1)]
        for i in range(0, n):
            for j in range(0, m):
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] + mat[i][j] - dp[i][j]
        ans = [[0] * m for _ in range(n)]
        for i in range(0, n):
            for j in range(0, m):
                r_i, r_j, l_i, l_j = min(i + k, n - 1), min(j + k, m - 1), max(i - k, 0), max(j - k, 0)
                ans[i][j] = dp[r_i + 1][r_j + 1] - dp[r_i + 1][l_j] - dp[l_i][r_j + 1] + dp[l_i][l_j]
        return ans


print(Solution().matrixBlockSum([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
], 1))
