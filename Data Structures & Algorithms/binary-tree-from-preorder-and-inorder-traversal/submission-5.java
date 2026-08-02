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
        int n = preorder.length;
        return helper(preorder, inorder, 0, n -1, 0);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int start, int end, int index) {
        if(start > end) return null;
        TreeNode node = new TreeNode(preorder[index]);

        int i = start;
        while(i < end && preorder[index] != inorder[i]) {
            i++;
        }
        int leftSize = i - start;

        node.left = helper(preorder, inorder,start, i - 1, index + 1);

        node.right = helper(preorder, inorder, i + 1, end, index + leftSize + 1);
        
        return node;
    }
}
