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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> res1 = new ArrayList<>();
        List<TreeNode> res2 = new ArrayList<>();

        helper(root1, res1);
        helper(root2, res2);

        if(res1.size() != res2.size()) {
            return false;
        }

        for(int i = 0;i < res1.size();i++) {
            if(res1.get(i).val != res2.get(i).val) return false;
        }
        return true;
    }

    void helper(TreeNode root, List<TreeNode> res) {
        if(root ==  null) return;
        if(root.left == null && root.right == null) res.add(root);

        if(root.left != null) {
            helper(root.left, res);
        }
        if(root.right != null) {
            helper(root.right, res);
        }
    }
}
