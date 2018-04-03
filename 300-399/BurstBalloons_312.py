class Solution(object):
    def maxCoins(self, nums):
        newnums = [1] + [i for i in nums if i > 0] + [1]
        '''
        add [1] both in left and right side to unify the operation for the whole array,
        get rid of 0's in nums since they don't produce any coins
        '''
        n = len(newnums)
        dp = [[0] * n for _ in xrange(n)]
        '''
        Using dynamic programming here
        Using i to divide the array,  a) If i is the first to burst in subarray, its left part and right part are still connected after
                                    b) If i is the ending balloon to burst, its left part and right part can't be treated as seperated
        We start from the shorter subarray and get the final upper outcome after.
        For a subarray, we don't take the starting point and the end into calculation.
        Like in the final problem 1 and 1 only take part in the final step.
        So when we move the sign j, it starts in (start + 1) and ends in (end - 1)
        '''
        
        for l in xrange(2, n):
            for start in xrange(0, n - l):
                end = start + l
                for j in xrange(start + 1, end):
                    dp[start][end] = max(dp[start][end], dp[start][j] + newnums[start] * newnums[j] * newnums[end] + dp[j][end])
        return dp[0][n - 1]
