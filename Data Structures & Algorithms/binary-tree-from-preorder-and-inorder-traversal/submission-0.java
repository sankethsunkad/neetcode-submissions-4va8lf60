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
        for(int i = 0;i < inorder.length;i++) {
            hm.put(inorder[i], i);
        }
        return constructTree(preorder, inorder, 0, inorder.length - 1);
    }
    int preorderIndex = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();

    public TreeNode constructTree(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) return null;
        TreeNode node = new TreeNode(preorder[preorderIndex++]);
        if(start == end) {
            return node;
        }        
        int i = hm.get(node.val);
        node.left = constructTree(preorder, inorder, start, i - 1);
        node.right = constructTree(preorder, inorder, i + 1, end);
        return node;
    }
}
