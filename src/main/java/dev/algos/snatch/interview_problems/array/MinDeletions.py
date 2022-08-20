import collections


class Solution:
    '''
    34123
    '''

    def minDeletions(self, s: str) -> int:
        cnts, used, ans = collections.Counter(s), set(), 0
        for ch, freq in cnts.items():
            while freq > 0 and freq in used:
                ans += 1
                freq -= 1
            used.add(freq)
        return ans


Solution().minDeletions("askodaksdjaosdjoaisjdoiajsdoiajda")
