class Solution(object):
    def canPartition(self, nums):
        s = sum(nums)
        if s % 2 == 1:
            return False
        find = False
        d = {nums[0] : 1}
        for num in nums[1:]:
            newd = {}
            for key in d:
                newd[key + num] = d.get(key + num, 0) + 1
            for key in newd:
                d[key] = d.get(key, 0) + newd[key]
            d[num] = d.get(num, 0) + 1
        return d.get(s / 2, 0) > 0
