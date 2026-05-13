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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.offer(root);
        }
        boolean pFound = false;
        boolean qFound = false;
        Stack<TreeNode> stack = new Stack<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0;i < size;i++) {
                TreeNode curr = queue.poll();
                if(curr.val ==  p.val) {
                    pFound = true;
                }
                if(curr.val == q.val) {
                    qFound = true;
                }
                stack.push(curr);
                if(pFound && qFound) {
                    return helper(stack, p, q);
                }
                if(curr.left != null) {
                    queue.offer(curr.left);
                }
                if(curr.right != null) {
                    queue.offer(curr.right);
                }
            }
        }
        return null;
    }

    public TreeNode helper(Stack<TreeNode> stack, TreeNode p, TreeNode q) {
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if(dfs(curr, p) && dfs(curr, q)) {
                return curr;
            }
        }
        return null;
    }

    public boolean dfs(TreeNode root, TreeNode target) {
        if(root == null) return false;
        if(root.val == target.val) return true;
        return dfs(root.left, target) || dfs(root.right, target);
    }
}
