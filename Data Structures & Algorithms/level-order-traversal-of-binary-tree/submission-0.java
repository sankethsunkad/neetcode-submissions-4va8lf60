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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            Queue<TreeNode> newQueue = new LinkedList<>();
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for(int i = 0;i < len;i++) {
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if(curr.left != null) newQueue.offer(curr.left);
                if(curr.right != null) newQueue.offer(curr.right);
            }
            res.add(list);
            queue = newQueue;
        }
        return res;
    }
}
