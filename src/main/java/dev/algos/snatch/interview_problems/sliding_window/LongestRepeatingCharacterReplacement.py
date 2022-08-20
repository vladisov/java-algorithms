from collections import defaultdict


class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        store = defaultdict(int)
        start, end, total, max_len = 0, 0, 0, 0
        while end < len(s):
            store[s[end]] += 1
            store_sorted = sorted(
                store.items(), key=lambda x: x[1], reverse=True)
            total += 1
            rest = total - store_sorted[0][1]
            end += 1
            while rest > k:
                store[s[start]] -= 1
                store_sorted = sorted(
                    store.items(), key=lambda x: x[1], reverse=True)
                total -= 1
                rest = total - store_sorted[0][1]
                start += 1
            max_len = max(max_len, end - start)
        return max_len


print(Solution().characterReplacement("AABABBA", 2))
