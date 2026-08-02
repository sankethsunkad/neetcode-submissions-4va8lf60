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
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        int n = preorder.length;
        for(int i = 0;i < n;i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, n -1, 0);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int start, int end, int index) {
        if(start > end) return null;
        TreeNode node = new TreeNode(preorder[index]);

        int i = map.get(preorder[index]);
        int leftSize = i - start;

        node.left = helper(preorder, inorder,start, i - 1, index + 1);

        node.right = helper(preorder, inorder, i + 1, end, index + leftSize + 1);
        
        return node;
    }
}
