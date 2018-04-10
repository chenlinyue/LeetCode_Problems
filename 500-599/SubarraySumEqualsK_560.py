class Solution(object):
    def subarraySum(self, nums, k):
        if not nums:
            return 0
        hash = {0:1}
        result, s = 0, 0
        for i in xrange(len(nums)):
            s += nums[i]
            result += hash.get(s - k, 0)
            hash[s] = hash.get(s, 0) + 1
        return result
        
        '''
        Assume a subarray starts from i and ends at j, then sum of this subarray is sum[j] - sum[i - 1] where sum[x]
        is the sum of nums[:x]
        With dictionary hash, we record the times of a pre sum, and (s - k) is the number to be find.
        Don't forget to initiate the dictionary of hash with hash[0] = 1.
        '''
