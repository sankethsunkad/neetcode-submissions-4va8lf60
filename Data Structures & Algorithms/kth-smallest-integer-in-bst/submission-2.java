/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        helper(root, stack, k);
        if(stack.size() == k) {
            return stack.pop().val;
        }
        return -1;
    }

    void helper(TreeNode root, Stack<TreeNode> res, int k) {
        if(root == null) {
            return;
        }
        helper(root.left, res, k);
        if(res.size() == k) return;
        res.push(root);
        helper(root.right, res, k);
    }
}
