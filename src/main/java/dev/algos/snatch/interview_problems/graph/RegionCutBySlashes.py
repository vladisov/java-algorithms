from itertools import product

'''
An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. 
These characters divide the square into contiguous regions.
Given the grid grid represented as a string array, return the number of regions.
Note that backslash characters are escaped, so a '\' is represented as '\\'.


Input: grid = 
["/\",
 "\/"]

001100
010010
100001
100001
010010
001100

Output: 5
Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
'''
class Solution(object):
    def regionsBySlashes(self, grid):
      if grid is None or len(grid) == 0:
        return 0
      n, m = len(grid), len(grid[0])
      matrix = [[0 for _ in range(m * 3)] for _ in range(n * 3)]
      def preprocess(grid):
        for i, j in product(range(n), range(m)):
          r, c = i * 3, j * 3
          if grid[i][j] == '/':
            matrix[r][c], matrix[r][c + 1], matrix[r][c + 2] = 0, 0, 1
            matrix[r + 1][c], matrix[r + 1][c + 1], matrix[r + 1][c + 2] = 0, 1, 0
            matrix[r + 2][c], matrix[r + 2][c + 1], matrix[r + 2][c + 2] = 1, 0, 0
          if grid[i][j] == '\\':
            matrix[r][c], matrix[r][c + 1], matrix[r][c + 2] = 1, 0, 0
            matrix[r + 1][c], matrix[r + 1][c + 1], matrix[r + 1][c + 2] = 0, 1, 0
            matrix[r + 2][c], matrix[r + 2][c + 1], matrix[r + 2][c + 2] = 0, 0, 1
              
      preprocess(grid)
      dirs = [[0,1],[0,-1],[1, 0],[-1, 0]]
      def dfs(matrix, i, j):
        if i < 0 or j < 0 or i == len(matrix) or j == len(matrix[0]) or matrix[i][j] == 1:
          return
        matrix[i][j] = 1
        for dir in dirs:
          dfs(matrix, i + dir[0], j + dir[1])
        
      count = 0
      for i in range(0, n * 3):
        for j in range(0, m * 3):
          if matrix[i][j] == 0:
            dfs(matrix, i, j)
            count += 1
      return count
        
        
print(Solution().regionsBySlashes(["/\\","\\/"]))