from typing import List


class Solution:
    def minMoves2(self, nums: List[int]) -> int:
        nums.sort()
        ans, median = 0, nums[len(nums) // 2]
        for num in nums:
            ans += abs(median - num)
        return ans


Solution().minMoves2([1, 0, 0, 8, 6])
