class Solution(object):
    def isSubtree(self, s, t):
        if not t:
            return True
        if not s:
            return False
        return self.isMatch(s, t) or self.isSubtree(s and s.left, t) or self.isSubtree(s and s.right, t)
        
    
    def isMatch(self, s, t):
        if not t and not s:
            return True
        if not t or not s:
            return False
        return s.val == t.val and self.isMatch(s.left, t.left) and self.isMatch(s.right, t.right)
        
   '''
   traverse the tree and determine whether a node is the root node for a subtree.
   '''
