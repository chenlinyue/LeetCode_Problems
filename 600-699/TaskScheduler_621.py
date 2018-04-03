class Solution(object):
    def leastInterval(self, tasks, n):
        if not tasks:
            return 0
        d = dict()
        for t in tasks:
            d[t] = d.get(t, 0) + 1
        mT = max(d.values())
        # d.values() is a function so don't forget the parenthesis ()
        c = d.values().count(mT)
        return max((mT - 1) * (n + 1) + c, len(tasks))
