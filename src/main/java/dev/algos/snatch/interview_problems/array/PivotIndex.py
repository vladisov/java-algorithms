from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        total = sum(nums)
        l = 0
        for i, num in enumerate(nums):
            l += num
            r = total - l - num
            if r == l:
                return i
        return -1
