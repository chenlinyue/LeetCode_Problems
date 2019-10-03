/*
The key to solve this problem here is the choice of the data structure. We need to access the node
up to down and left right. So we can't do things recursively here. Instead, we should utilize Queue to
implement a BFS search of nodes. And in the process, we need to store all the positions(cols) of a node.
*/
public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) return res;

    Map<Integer, List<Integer>> map = new HashMap<>();

    Queue<TreeNode> nodes = new LinkedList<>();
    Queue<Integer> pos = new LinkedList<>();

    nodes.add(root);
    pos.add(0);
    int min = 0, max = 0;

    while (!nodes.isEmpty()){
        int position = pos.poll();
        TreeNode node = nodes.poll();
        if (!map.containsKey(position))
            map.put(position, new ArrayList<Integer>());
        map.get(position).add(node.val);

        if (node.left != null){
            nodes.add(node.left);
            pos.add(position - 1);
            min = Math.min(min, position - 1);
        }

        if (node.right != null){
            nodes.add(node.right);
            pos.add(position + 1);
            max = Math.max(max, position + 1);
        }
    }

    for (int i = min; i <= max; i++){
        res.add(map.get(i));
    }
    return res;
}
