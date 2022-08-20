from typing import List


class Solution:
    def maxScore(self, arr: List[int], k: int) -> int:
        sum = 0
        size = len(arr) - k
        for i in range(0, size):
            sum += arr[i]
        min = sum
        total = sum
        for i in range(size, len(arr)):
            total += arr[i]
            sum -= arr[i - size]
            sum += arr[i]
            if sum < min:
                min = sum
        return total - min


Solution().maxScore([1, 2, 3, 4, 5, 6, 1], 3)
