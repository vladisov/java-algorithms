
import heapq
from typing import List


class Solution:
    def isPossible(self, target: List[int]) -> bool:
        if len(target) == 1 and target[0] != 1:
            return False
        total = sum(target)
        heap = []
        for num in target:
            heapq.heappush(heap, -num)
        while True:
            top = -heapq.heappop(heap)
            left = total - top
            if top == 1 or left == 1:
                return True

            if left >= top or top % left == 0:
                return False
            heapq.heappush(heap, -(top % left))
            total = left + top % left
        return True


print(Solution().isPossible([1, 1, 1, 2]))
print(Solution().isPossible([1, 1000000000]))
print(Solution().isPossible([8, 3]))
print(Solution().isPossible([9, 3, 5]))
print(Solution().isPossible([5]))
