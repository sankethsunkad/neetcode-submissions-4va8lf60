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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(head != null) {
            ListNode tailNode = head;
            for(int i = 0;i < k;i++) {
                if(tailNode == null) {
                    return res.next;
                }
                tailNode = tailNode.next;
            }
            dummy.next = reverse(head, k);
            int counter = 0;
            while(counter < k) {
                dummy = dummy.next;
                counter++;
            }
            dummy.next = tailNode;
            head = dummy.next;
        }
        return res.next;
    }
    
    ListNode reverse(ListNode head, int k) {
        int counter = 0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode;
        while(counter < k) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            counter++;
        }
        return prev;
    }
}
