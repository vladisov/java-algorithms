from typing import List


class Solution:
    def candy(self, ratings: List[int]) -> int:
        ans = [1 for _ in range(len(ratings))]
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                ans[i] += 1
        for i in reversed(range(len(ratings) - 1)):
            if ratings[i] > ratings[i + 1]:
                ans[i] += 1
        return sum(ans)


print(Solution().candy([1, 2, 2]))
print(Solution().candy([1, 0, 2]))
