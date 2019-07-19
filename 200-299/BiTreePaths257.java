public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null) return result;
    dfsPath(root, result, "");
    return result;
}

public void dfsPath(TreeNode node, List<String> result, String path){
    if (node == null) return;
    String temp = new String(path);
    if (node.left == null && node.right == null){
        path += node.val;
        result.add(path);
        path = temp;
    }else{
        path += (node.val + "->");
        if (node.left != null)
            dfsPath(node.left, result, path);
        if (node.right != null)
            dfsPath(node.right, result, path);
        path = temp;
    }
}
