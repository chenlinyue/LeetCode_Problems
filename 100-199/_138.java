/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node pointer = head;
        while (pointer != null){
            map.put(pointer, new Node(pointer.val, null, null));
            pointer = pointer.next;
        }
        pointer = head;
        while (pointer != null){
            map.get(pointer).next = map.get(pointer.next);
            map.get(pointer).random = map.get(pointer.random);
            pointer = pointer.next;
        }
        return map.get(head);
    }
}

// The key to solve this problem is to find the correct map pair
