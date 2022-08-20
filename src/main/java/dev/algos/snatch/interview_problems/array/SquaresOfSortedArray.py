from typing import List


class Solution:
    def sqr(self, val: int) -> int:
        return val * val

    def sortedSquares(self, nums: List[int]) -> List[int]:
        arr = []
        lo, hi = 0, len(nums) - 1
        while lo <= hi:
            if self.sqr(nums[lo]) < self.sqr(nums[hi]):
                arr.append(self.sqr(nums[hi]))
                hi -= 1
            else:
                arr.append(self.sqr(nums[lo]))
                lo += 1
        return arr[::-1]


print(Solution().sortedSquares(nums=[-7, -3, 2, 3, 11]))
