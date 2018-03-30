# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    '''
    the previous solution is has some repeat operation
    in this case cut the repetition and make the time complexity to O(n)
    '''
    
    def diameterOfBinaryTree(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.ans = 0
        def depth(node):
            if node:
                left, right = depth(node.left), depth(node.right)
                self.ans = max(self.ans, left + right)
                return max(left, right) + 1
            else:
                return 0
        depth(root)
        return self.ans
