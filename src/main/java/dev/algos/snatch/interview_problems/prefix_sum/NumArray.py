from typing import List


class NumArray:

    def __init__(self, nums: List[int]):
        self.pre = [0]
        for num in nums:
            self.pre.append(num + self.pre[-1])

    def sumRange(self, left: int, right: int) -> int:
        return self.pre[right + 1] - self.pre[left]
