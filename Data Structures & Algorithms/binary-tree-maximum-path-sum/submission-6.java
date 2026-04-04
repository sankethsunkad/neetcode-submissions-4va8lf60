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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        if(root.val < 0) {
            int returnValue = Math.max(left, right) + root.val;
            max = Math.max(max, left + right + root.val);
            returnValue = Math.max(returnValue, 0);
            return returnValue;
        }
        int total = left + right + root.val;
        int returnValue = Math.max(left, right) + root.val;
        max = Math.max(max, Math.max(total, returnValue));
        return Math.max(left, right) + root.val;
    }
}
