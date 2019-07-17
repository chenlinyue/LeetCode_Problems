public int minDepth(TreeNode root) {
    if (root == null) return 0;
    int leftH = minDepth(root.left);
    int rightH = minDepth(root.right);
    if (leftH == 0)
        return rightH == 0 ? 1 : rightH + 1;
    else 
        return rightH == 0 ? leftH + 1 : Math.min(leftH, rightH) + 1;
}
