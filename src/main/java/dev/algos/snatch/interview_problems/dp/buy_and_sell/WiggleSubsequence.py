from functools import lru_cache
from typing import List


class Solution:
    def wiggleMaxLength(self, nums: List[int]) -> int:
        down = [0 for _ in range(len(nums))]
        up = [0 for _ in range(len(nums))]
        up[0] = down[0] = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                up[i] = max(1 + down[i - 1], up[i - 1])
            elif nums[i] < nums[i - 1]:
                down[i] = max(1 + up[i - 1], down[i - 1])
            else:
                up[i] = up[i - 1]
                down[i] = down[i - 1]
        return max(up[len(nums) - 1], down[len(nums) - 1])


print(Solution().wiggleMaxLength([1, 7, 4, 9, 2, 5]))
print(Solution().wiggleMaxLength([1, 17, 5, 10, 13, 15, 10, 5, 16, 8]))
