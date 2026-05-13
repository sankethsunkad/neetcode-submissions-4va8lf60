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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return helper(root, Integer.MIN_VALUE);
    }

    int helper(TreeNode root, int max) {
        if(root == null) return 0;
        int res = 0;
        if(root.val >= max) {
            res = 1;
        }
        return res + helper(root.left, Math.max(max, root.val)) + helper(root.right, Math.max(max, root.val));
    }
}
