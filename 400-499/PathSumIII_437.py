class Solution(object):
    def pathSum(self, root, s):
        if root:
            return self.Upto(root, s) + self.pathSum(root.left, s) + self.pathSum(root.right, s)
        else:
            return 0
        
    def Upto(self, node, s):
        if not node:
            return 0
        else:
            return (1 if node.val == s else 0) + self.Upto(node.left, s - node.val) + self.Upto(node.right, s - node.val)
            
    '''
    At first, I think about using a list to record all the possible sum from upper treenode. But it would cost a great amount
    of space and it's a colossal waste. Here is a solution from leetcode and the space complexity is O(n) and time complexity
    from O(nlgn)(balanced) to O(n^2)(worst)
    '''
