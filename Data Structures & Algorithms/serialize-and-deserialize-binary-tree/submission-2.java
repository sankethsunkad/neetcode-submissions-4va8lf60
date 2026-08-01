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
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeTree(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(index == data.length()) return null;
        
        if(data.charAt(index) == 'N') return null;

        int j = index + 1;
        while(j < data.length () && data.charAt(j) != ',') {
            j++;
        }
        System.out.println("index = " + index);
        System.out.println("j = " + j);
        System.out.println("substring = [" + data.substring(index, j) + "]");
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(index, j)));
        index = j + 1;
        root.left = deserialize(data);
        index++;
        root.right = deserialize(data);
        return root;
    }

    void serializeTree(TreeNode root, StringBuilder sb) {
        if(root == null){
            sb.append("N");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        serializeTree(root.left, sb);
        serializeTree(root.right, sb);
    }

}
