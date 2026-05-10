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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            len++;
            curr = curr.next;
        }
        if(len == n) {
            return head.next;
        }

        curr = head;

        for(int i = 0;i < (len - n - 1);i++) {
            curr = curr.next;
        }
        
        if(curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
        }
        return head;
    }
}
