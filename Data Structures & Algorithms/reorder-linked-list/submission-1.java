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
        if(head == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        int len = 0;
        while(curr != null) {
            stack.push(curr);
            curr = curr.next;
            len++;
        }
        curr = head;
        int count = 0;
        for(int i = 0;i < len / 2;i++) {
            ListNode next = curr.next;
            curr.next = stack.pop();
            curr.next.next = next;
            curr = next;
        }
        curr.next = null;
    }
}
