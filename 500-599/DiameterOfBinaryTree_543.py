# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def diameterOfBinaryTree(self, root):
        """
        traverse the tree and find the answer of the case the the treenode is in the path
        the longest diameter will be the greatest depth from left plus the greatesr depth from right
        """
        if root:
            mD = max(self.diameterOfBinaryTree(root.left), 
                     self.diameterOfBinaryTree(root.right), 
                     self.getDep(root.left) + self.getDep(root.right))
            return mD
        else:
            return 0
    
    
    def getDep(self, node):
            if not node:
                return 0
            else:
                return max(self.getDep(node.left), self.getDep(node.right)) + 1
