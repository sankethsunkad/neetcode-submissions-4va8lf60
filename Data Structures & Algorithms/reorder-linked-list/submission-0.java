/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        curr = head;
        int n = stack.size();

        for(int i = 0;i < n/2;i++) {
            ListNode nextNode = curr.next;
            ListNode last = stack.pop();

            curr.next = last;
            last.next = nextNode;
            curr = nextNode;
        }
        curr.next = null;
    }
}
