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
    public boolean isBalanced(TreeNode root) {
        int[] res = new int[2];
        res = helper(root);
        return res[0] == 1;
    }
    
    public int[] helper(TreeNode root) {
        if(root == null) return new int[]{1, 0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int diff = Math.max(left[1], right[1]);
        if(left[0] == 0 || right[0] == 0) {
            return new int[]{0, 1 + diff};
        }
        if(Math.abs(left[1] - right[1]) > 1) {
            return new int[]{0, 1 + diff};
        }
        return new int[]{1, 1 + diff};
    }
}
