/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {   
        return checkSum(root, L, R);
    }
    
    private int checkSum(TreeNode root, int L, int R){
        int result = 0;
        if (root == null){
            return 0;
        }else if (root.val < L){
            result += checkSum(root.right, L, R);
        }else if (root.val > R){
            result += checkSum(root.left, L, R);
        }else{
            result = result + root.val + checkSum(root.left, L, R) + checkSum(root.right, L, R);
        }
        return result;
    }
    // Using recursive method to solve problems about Binary Search Tree
}
