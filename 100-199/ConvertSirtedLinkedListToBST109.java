public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;

    return subRoot(head, null);
}

public TreeNode subRoot(ListNode head, ListNode tail){
    if (head == tail) return null;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != tail && fast.next != tail){
        fast = fast.next.next;
        slow = slow.next;
    }

    TreeNode root = new TreeNode(slow.val);
    root.left = subRoot(head, slow);
    root.right = subRoot(slow.next, tail);

    return root;
}
