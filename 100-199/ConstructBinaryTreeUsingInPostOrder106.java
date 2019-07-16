public TreeNode buildTree(int[] inorder, int[] postorder) {
    int len = inorder.length, lenPost = postorder.length;
    if (len == 0 || lenPost == 0 || len != lenPost) return null;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for (int i = 0; i < len; i++){
        hm.put(inorder[i], i);
    }

    return buildSubTree(inorder, 0, len - 1, postorder, 0, len - 1, hm);
}

private TreeNode buildSubTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend, HashMap<Integer, Integer> hm){
    if (istart > iend || pstart > pend) return null;
    TreeNode root = new TreeNode(postorder[pend]);
    int posDe = hm.get(postorder[pend]);

    root.left = buildSubTree(inorder, istart, posDe - 1, postorder, pstart, pstart + posDe - istart - 1, hm);
    root.right = buildSubTree(inorder, posDe + 1, iend, postorder, pend - iend + posDe, pend - 1, hm);
    return root;
}
