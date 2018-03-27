class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        i = 0
        count = 0
        while i < len(nums):
            if nums[i] == 0:
                del nums[i]     # while using del, nums change and automatically len(nums) too
                count += 1
            else:
                i += 1
        nums += [0] * count   # extend nums with correct number of 0
        
        
'''
there is a one line solution from Discuss and it's:
nums.sort(key = lamda k: 1 k == 0 else 0)
'''
