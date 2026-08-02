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
    int res = -1;
    int ind;
    public int kthSmallest(TreeNode root, int k) {
        ind = k;
        helper(root);
        return res;
    }

    void helper(TreeNode root) {
        if(root == null || ind < 0) return;
        helper(root.left);
        ind--;
        if(ind == 0) {
            res = root.val;
            return;
        }
        helper(root.right);
    }
}
