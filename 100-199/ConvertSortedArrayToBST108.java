public TreeNode sortedArrayToBST(int[] nums) {
    int len = nums.length;
    if (len <= 0) return null;
    return getSubRoot(nums, 0, len - 1);
}

private TreeNode getSubRoot(int[] vals, int vs, int ve){
    if (vs > ve) return null;
    int mid = (vs + ve) / 2;
    TreeNode root = new TreeNode(vals[mid]);
    root.left = getSubRoot(vals, vs, mid - 1);
    root.right = getSubRoot(vals, mid + 1, ve);

    return root;
}
