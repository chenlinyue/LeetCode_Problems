class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        result = [0]
        for i in range(1, num + 1):
            this = result[i / 2] + i % 2
            '''
            result[i / 2] is the number of 1 in i besides the last digit and i % 2 desides whether it's 1 or not
            to make sure this works, initiate result[0] first
            '''
            result.append(this)
        return result
