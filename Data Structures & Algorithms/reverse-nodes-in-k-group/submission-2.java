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
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        dummy.next = head;
        ListNode prev = res;
        dummy = dummy.next;
        while(dummy != null) {
            if(checkKNodes(dummy, k)) {
                ListNode next = traverseKNodes(dummy, k);
                ListNode temp = reverse(dummy, k);
                prev.next = temp;
                prev = traverseKNodes(temp, k - 1);
                prev.next = next;
                dummy = prev.next;
            }
            else {
                return res.next;
            }
        }
        return res.next;
    }

    public ListNode reverse(ListNode node, int k) {
        ListNode dummy = node;
        Stack<ListNode> stack = new Stack<>();
        while(k > 0 && dummy != null) {
            stack.push(dummy);
            dummy = dummy.next;
            k--;
        }

        ListNode res = new ListNode(0);
        dummy = res;
        while(!stack.isEmpty()) {
            dummy.next = stack.pop();
            dummy = dummy.next;
        }
        return res.next;
    }

    public ListNode traverseKNodes(ListNode node, int k) {
        while(k > 0 && node != null) {
            node = node.next;
            k--;
        }
        return node;
    }

    public boolean checkKNodes(ListNode node, int k) {
        while(k > 0 && node != null) {
            node = node.next;
            k--;
            if(k == 0) return true;
        }
        return false;
    }
}
