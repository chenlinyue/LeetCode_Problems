public List<List<Integer>> pathSum(TreeNode root, int sum) {

    List<List<Integer>> res = new ArrayList<>();

    if (root == null) return res;
    List<Integer> path = new ArrayList<>();

    getPath(root, sum, path, res);

    return res;

}

public void getPath(TreeNode node, int target, 
             List<Integer> path, List<List<Integer>> res){  
    path.add(node.val);

    if (node.left == null && node.right == null && target - node.val == 0){
        List<Integer> tempPath = new ArrayList<>(path);
        res.add(tempPath);
    }else{
        if (node.left != null)
            getPath(node.left, target - node.val, path, res);
        if (node.right != null)
            getPath(node.right, target - node.val, path, res);
    }
    path.remove(path.size() - 1);
}
