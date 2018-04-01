class Solution(object):
    def findDuplicate(self, nums):
    '''
    we use low and high to represent the numbers(without duplicate)
    '''
        low = 1
        high = len(nums) - 1
        while low < high:
            mid = (low + high) / 2
            count = 0
            '''
            ATTENTION!when use binary search (or its other forms), the judge must have interaction with the mid elements
            otherwise it may loop endlessly
            In this case, we use pigeonhole principle to calculate where the duplicate possibly happens
            record the numbers that is equal to or smaller than mid, count bigger than mid suggesting that duplicate happens during low and mid
            Do not use k bigger and count > high - mid as a judgement, for high might change during the process
            '''
            for k in nums:
                if k <= mid:
                    count += 1
            if count <= mid:
                low = mid + 1
            else:
                high = mid
        return low
