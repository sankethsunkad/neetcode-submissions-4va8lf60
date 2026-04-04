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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = l1;
        ListNode curr = l1;
        ListNode prev = null;
        int num1 = convertNum(l1);
        int num2 = convertNum(l2);
        num1 = num1 + num2;
        while(num1 != 0) {
            int digit = num1 % 10;
            num1 = num1 / 10;
            if(curr != null) {
                curr.val = digit;
            }
            else {
                ListNode listNode = new ListNode(digit);
                prev.next = listNode;
                curr = listNode;
            }
            prev = curr;
            curr = curr.next;
        }
        return root;
    }

    public int convertNum(ListNode l1) {
        Stack<Integer> stack = new Stack<>();
        while(l1 != null) {
            stack.push(l1.val);
            l1 = l1.next;
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum = stack.pop() + (sum * 10);
        }
        return sum;
    }
}
