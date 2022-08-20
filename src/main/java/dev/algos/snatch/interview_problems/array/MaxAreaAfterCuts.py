from pip import List


class Solution:
    def maxArea(self, h: int, w: int, h_cuts: List[int], v_cuts: List[int]) -> int:
        v_cuts = [0, *v_cuts, w]
        h_cuts = [0, *h_cuts, h]
        max_w, max_h = 0, 0
        for i in range(len(v_cuts) - 1):
            max_w = max(max_w, v_cuts[i + 1] - v_cuts[i])
        for i in range(len(h_cuts) - 1):
            max_h = max(max_h, h_cuts[i + 1] - h_cuts[i])
        return int((max_h * max_w) % 10e9)


print(Solution().maxArea(5, 4, [1, 2, 4], [1, 3]))
