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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        dummy.next = list1;

        int index = 0;
        ListNode prev = dummy;
        ListNode curr = prev.next;
        while(index < a) {
            prev = curr;
            curr = prev.next;
            index++;
        }
        
        prev.next = list2;
        
        while(prev.next != null) {
            prev = prev.next;
        }
        
        while(index < b){
            curr = curr.next;
            index++;
        }
        prev.next = curr.next;
        return dummy.next;
    }
}
