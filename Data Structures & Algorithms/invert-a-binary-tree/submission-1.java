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
    // public TreeNode invertTree(TreeNode root) {
    //     if(root == null) {
    //         return root;
    //     }
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while(!queue.isEmpty()) {
    //         TreeNode node = queue.poll();
    //         TreeNode left = node.left;
    //         node.left = node.right;
    //         node.right = left;

    //         if(node.left != null) {
    //             queue.offer(node.left);
    //         }

    //         if(node.right != null) {
    //             queue.offer(node.right);
    //         }
    //     }
    //     return root;
    // }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
