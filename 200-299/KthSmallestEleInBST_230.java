public int kthSmallest(TreeNode root, int k) {
    if (root == null) return 0;
    TreeNode node = root;
    int leftCount = countNodes(node.left);
    if (leftCount == k - 1) return node.val;
    else if (leftCount < k - 1) return kthSmallest(node.right, k - leftCount - 1);
    else return kthSmallest(node.left, k);
}

public int countNodes(TreeNode root){
    if (root == null) return 0;
    else return 1 + countNodes(root.left) + countNodes(root.right);
}
