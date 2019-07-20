public boolean isPalindrome(ListNode head) {

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null){
        fast = fast.next.next;
        slow = slow.next;
    }

    ListNode latterHead = reverse(slow);

    while (latterHead != null){
        if (head.val != latterHead.val) return false;
        else{
            head = head.next;
            latterHead = latterHead.next;
        }
    }

    return true;

}

public ListNode reverse(ListNode node){
    ListNode pre = null;
    ListNode post;
    while (node != null){
        post = node.next;
        node.next = pre;
        pre = node;
        node = post;
    }
    return pre;
}
