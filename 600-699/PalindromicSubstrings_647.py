class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        count = len(s)
        '''
        all the character itself can be treated like a palindromic substring, 
        so we initiate count with the number of characters
        '''
        for i in range(len(s)):
        '''
        case#1:
        s[i] is exactly the center of of the substring
        case#2:
        s[i] and s[i - 1] are in the center of the substring
        
        don't forget to check the boundary first
        '''
            j, k = i - 1, i
            while j >= 0 and k < len(s) and s[j] == s[k]:
                count += 1
                j -= 1
                k += 1
            j, k = i - 1, i + 1
            while j >= 0 and k < len(s) and s[j] == s[k]:
                count += 1
                j -= 1
                k += 1
        return count
