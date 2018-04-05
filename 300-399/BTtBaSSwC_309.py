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
    '''
    At first, we use 
    s0 to represent the state we call post-rest, it can still rest or get to buy some stcok;
    s1 represent a state where we call post-buy, it can rest and get to sell those stock just bought;
    s2 present the state called post-sell, it must rest to get to state s0 or iteself.
    Now we can get that for day i:
        s0[i] = max(s0[i - 1], s2[i - 1])
        s1[i] = max(s0[i - 1] - prices, s1[i - 1])
        s2[i] = max(s1[i - 1] + prices[i], s2[i - 1])
    and since s2[i - 1] is no less than s0[i - 1], we can say that s0[i] = s2[i - 1]
    At last, we can get these:
        s1[i] = max(s0[i - 2] - prices, s1[i - 1])
        s2[i] = max(s1[i - 1] + prices[i], s2[i - 1])      
   '''
    
        
