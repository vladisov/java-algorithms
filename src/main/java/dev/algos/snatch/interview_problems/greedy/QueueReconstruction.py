from typing import List


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda p: (-p[0], p[1]))
        ans = []
        for person in people:
            self.insert_person(person, ans)
        return ans

    def insert_person(self, person: List[int], ans: List[List[int]]):
        be_taller = person[1]
        for i in range(len(ans) + 1):
            if be_taller == 0:
                ans.insert(0, person)
                return
            elif i < len(ans):
                if ans[i][0] >= person[0]:
                    be_taller -= 1
                    if be_taller == 0:
                        ans.insert(i + 1, person)
                        return
            else:
                ans.append(person)


Solution().reconstructQueue([[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]])
