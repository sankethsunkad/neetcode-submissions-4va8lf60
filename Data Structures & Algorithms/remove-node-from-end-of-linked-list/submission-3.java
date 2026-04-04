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
        ListNode curr = head;
        int len = 0;
        while(curr != null) {
            curr = curr.next;
            len++;
        }
        if(len == n) {
            return head.next;
        }
        int i = 0;
        curr = head;

        while(i < (len - n - 1)) {
            curr = curr.next;
            i++;
        }
        if(curr.next != null) {
            ListNode next = curr.next;
            curr.next = next.next;
        }
        return head;
    }
}
