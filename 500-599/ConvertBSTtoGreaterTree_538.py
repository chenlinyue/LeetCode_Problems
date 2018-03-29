# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        self.convert(root, 0)
        return root
        
    # we use last ro represent the number a node need to add up to
    def convert(self, node, last):
        if node:
            last = self.convert(node.right, last)
            node.val += last
            last = node.val
            last = self.convert(node.left, last)
            return last
        else:
            return last
