public Node connect(Node root) {
    if (root == null) return null;
    Node pre = root, cur;
    while (pre.left != null){
        cur = pre;
        while (cur != null){
            cur.left.next = cur.right;
            cur.right.next = (cur.next == null ? null : cur.next.left) ;
            cur = cur.next;
        }
        pre = pre.left; // layer by layer
    }

    return root;
}
