class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new List[n + 1];
        res[0] = new ArrayList<TreeNode>();
        if (n < 1){
            return res[0];
        }
        res[0].add(null);
        
        for (int i = 1; i < n + 1; i++){
            res[i] = new ArrayList<TreeNode>();

            for (int j = 1; j <= i; j++){
                for (TreeNode nleft: res[j - 1]){
                    for (TreeNode nright: res[i - j]){
                        TreeNode tempRoot = new TreeNode(j);
                        tempRoot.left = nleft;
                        tempRoot.right = nodeOffset(nright, j);
                        res[i].add(tempRoot);
                    }
                }
            }
        }
        return res[n];
        
    }
    
    private TreeNode nodeOffset(TreeNode node, int offset){
        if (node != null){
            TreeNode nNode = new TreeNode(node.val + offset);
            nNode.left = nodeOffset(node.left, offset);
            nNode.right = nodeOffset(node.right, offset);
            return nNode;
        }else{
            return node;
        }
    }
}
