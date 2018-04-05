class Solution(object):
    def maxProfit(self, prices):
        if len(prices) < 2:
            return 0
        s1, s2, pre_s1, pre_s2 = -prices[0], 0, 0, 0
        for price in prices:
            pre_s1 = s1
            s1 = max(pre_s2 - price, pre_s1)
            pre_s2 = s2
            s2 = max(pre_s1 + price, pre_s2)
        return s2
