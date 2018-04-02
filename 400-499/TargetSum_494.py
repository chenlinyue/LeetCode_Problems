class Solution(object):
    def findTargetSumWays(self, nums, S):
        if not nums:
            return 0
        '''
        initiate d for a better use of get after
        '''
        d = {nums[0]: 1, -nums[0]: 1} if nums[0] else {0: 2}
        for num in nums[1:]:
            t = {}
            for k in d:
                t[k + num] = t.get(k + num, 0) + d.get(k, 0)
                t[k - num] = t.get(k - num, 0) + d.get(k, 0)
            d = t
            '''
            using a new dict because we shoudln't change d while it is still iterating
            the key idea is to use DP and record the times every result could come up
            t[k + num] = the older t[k + num] + new way to get [k + num] from d[k]
            '''
        return d.get(S, 0)  #retuen a get in case we can not get S in this way
