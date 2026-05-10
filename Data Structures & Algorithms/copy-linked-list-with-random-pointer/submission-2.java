/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        Node curr = head;
        while(curr != null) {
            if(!hm.containsKey(curr)) {
                Node node = new Node(curr.val);
                hm.put(curr, node);
            }
            curr = curr.next;
        }

        curr = head;
        while(curr != null) {
            Node copyCurr = hm.get(curr);
            copyCurr.next = hm.get(curr.next);
            copyCurr.random = hm.get(curr.random);
            curr = curr.next;
        }
        return hm.get(head);
    }
}
