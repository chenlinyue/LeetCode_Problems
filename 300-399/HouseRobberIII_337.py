# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rob(self, root):
        return self.robMost(root)[1]
    
    '''
    return value (biggest(node), withoutNode(node))
    biggest is the biggest amount can be robbed start from node
    withoutNode is the biggest amount can be robbed when not robbing node
    
    biggest(node) = max(withoutNode(node.left) + withoutNode(node.right) + node.val, biggest(node.left) + biggest(node.right))
    withoutNode(node) = biggest(node.left) + biggest(node.right)
    think about the recursion, reduce them to necessary times
    '''
    def robMost(self, node):
        if not node:
            return (0, 0)
        else:
            left = self.robMost(node.left)
            right = self.robMost(node.right)
            return (left[1] + right[1], max(left[0] + right[0] + node.val, left[1] + right[1]))
