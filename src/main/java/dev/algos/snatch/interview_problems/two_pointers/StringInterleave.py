from functools import lru_cache


class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        @lru_cache
        def dp(i, j, k, s1, s2, s3):
            if i == len(s1) and j == len(s2) and k == len(s3):
                return True
            if k == len(s3) and (i != len(s1) or j != len(s2)):
                return False
            ans1, ans2 = False, False
            if i < len(s1) and s1[i] == s3[k]:
                ans1 = dp(i + 1, j, k + 1, s1, s2, s3)
            if j < len(s2) and s2[j] == s3[k]:
                ans2 = dp(i, j + 1, k + 1, s1, s2, s3)
            return ans1 or ans2
        return dp(0, 0, 0, s1, s2, s3)


print(Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac"))
