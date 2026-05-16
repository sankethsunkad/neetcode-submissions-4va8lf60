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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, preorder.length - 1, preorder, inorder);   
    }

    public TreeNode helper(int preorderIndex, int inorderStart, int inorderEnd, int[] preorder, int[] inorder) {
        if(inorderStart > inorderEnd) return null;

        TreeNode root = new TreeNode(preorder[preorderIndex]);
        int i = inorderStart;
        while(i <= inorderEnd && inorder[i] != preorder[preorderIndex]) {
            i++;
        }
        int leftSize = i - inorderStart;
        root.left = helper(preorderIndex + 1, inorderStart, i - 1, preorder, inorder);
        root.right = helper(preorderIndex + leftSize + 1, i + 1, inorderEnd, preorder, inorder);
        return root;
    }
}
