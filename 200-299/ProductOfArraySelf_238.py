class Solution(object):
    def productExceptSelf(self, nums):
        result = []
        p = 1
        n = len(nums)
        '''
        since we can't use division here, the product except self is determined by the numbers from left and right
        we just hace to fo over the array from left to right and from right to left
        xrange is similar to range yet does not create an actual list
        '''
        for i in xrange(n):
            result.append(p)
            p *= nums[i]
        p = 1
        for i in xrange(n - 1, -1, -1):
            result[i] *= p
            p *= nums[i]
        return result
