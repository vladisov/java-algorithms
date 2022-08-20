from collections import deque
from typing import List


class Solution:
    # O(NK) sucks
    def maxResult(self, nums: List[int], k: int) -> int:
        def dp(nums, i, k, memo):
            if i >= (len(nums) - 1):
                return nums[len(nums) - 1]
            if i in memo:
                return memo[i]
            res = -1e8
            for j in range(i + 1, i + k + 1):
                res = max(res, nums[i] + dp(nums, j, k, memo))
            memo[i] = res
            return res
        return dp(nums, 0, k, dict())

    # still O(NK) still sucks
    def maxResultDP(self, nums: List[int], k: int) -> int:
        dp, n = [-1e8] * len(nums), len(nums)
        dp[n - 1] = nums[n - 1]
        for i in reversed(range(n - 1)):
            for j in range(i + 1, min(i + k + 1, n)):
                dp[i] = max(dp[i], nums[i] + dp[j])
        return dp[0]

    def maxResultDP1(self, nums: List[int], k: int) -> int:
        dp, n = [-1e8] * len(nums), len(nums)
        dp[0] = nums[0]
        for i in range(1, n):
            for j in range(max(0, i - k), i):
                dp[i] = max(dp[i], nums[i] + dp[j])
        return dp[-1]

    # O(N) coz each el is popped once
    def maxResultDP2(self, nums: List[int], k: int) -> int:
        n = len(nums)
        dp = [0] * n
        dp[0] = nums[0]
        dq = deque()
        dq.append(0)
        for i in range(1, n):
            while dq and dq[0] < i - k:
                dq.popleft()
            dp[i] = dp[dq[0]] + nums[i]
            while dq and dp[i] >= dp[dq[-1]]:
                dq.pop()
            dq.append(i)
        return dp[-1]


print(Solution().maxResultDP2([1, -1, -2, 4, -7, 3], 2))
print(Solution().maxResultDP2([10, -5, -7, 3, 2], 3))
print(Solution().maxResultDP2([10, -5, -2, 4, 0, 3], 3))
