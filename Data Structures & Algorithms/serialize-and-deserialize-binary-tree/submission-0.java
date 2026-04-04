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

public class Codec {
    int index = 0;
    List<Character> res;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        res = new ArrayList<>();
        serializeTree(root);
        return res.stream().map(String::valueOf).collect(Collectors.joining());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(index == data.length()) return null;
        
        if(data.charAt(index) == 'N') return null;

        TreeNode root = new TreeNode(data.charAt(index));
        index++;
        root.left = deserialize(data);
        index++;
        root.right = deserialize(data);
        return root;
    }

    void serializeTree(TreeNode root) {
        if(root == null){
            res.add(Character.valueOf('N'));
            return;
        }
        res.add((char)root.val);
        serializeTree(root.left);
        serializeTree(root.right);
    }

}
