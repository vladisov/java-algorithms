from typing import List


class Solution:

    '''
    Input: obstacles = [0,1,2,3,0]
    Output: 2
    Explanation: The optimal solution is shown by the arrows above. There are 2 side jumps (red arrows).
    Note that the frog can jump over obstacles only when making side jumps (as shown at point 2).

    TC O(N*16)
    '''

    def minSideJumps(self, obstacles: List[int]) -> int:
        self.dirs = [1, -1, 2, -2]
        self.memo = [[-1] * (len(obstacles) + 1)
                     for _ in range(4)]

        def helper(index: int, lane: int, obstacles: List[int]) -> int:
            if lane < 1 or lane > 3 or obstacles[index] == lane:
                return 10e5
            if index == len(obstacles) - 1:
                return 0
            if self.memo[lane][index] != -1:
                return self.memo[lane][index]

            if obstacles[index + 1] == lane:
                for dir in self.dirs:
                    next = lane + dir
                    if next < 1 or next > 3 or obstacles[index] == next or obstacles[index + 1] == next:
                        continue
                    ans = min(ans, 1 + helper(index + 1, next, obstacles))
            else:
                ans = helper(index + 1, lane, obstacles)
            self.memo[lane][index] = ans
            return ans

        return helper(0, 2, obstacles)


print(Solution().minSideJumps([0, 1, 2, 3, 0]))
