from typing import List


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        sum, max = 0, -10e5
        for i in range(0, len(nums)):
            sum += nums[i]
            if (i >= k):
                max = max(sum/k, max)
                sum -= nums[i]
        return max
