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
        if(root == null) return true;
        HashMap<TreeNode, Integer> hm = new HashMap<>();
        if(Math.abs(getHeight(root.left, hm) - getHeight(root.right, hm)) > 1 ) return false;
        return isBalanced(root.left, hm) && isBalanced(root.right, hm);
    }
    public boolean isBalanced(TreeNode root, HashMap<TreeNode, Integer> hm) {
        if(root == null) return true;
        if(Math.abs(getHeight(root.left, hm) - getHeight(root.right, hm)) > 1 ) return false;
        return isBalanced(root.left, hm) && isBalanced(root.right, hm);
    }
    public int getHeight(TreeNode root, HashMap<TreeNode, Integer> hm) {
        if(hm.containsKey(root)) return hm.get(root);
        if(root == null) return 0;
        int length = 1 + Math.max(getHeight(root.right, hm), getHeight(root.left, hm));
        hm.put(root, length);
        return hm.get(root);
    }

}
