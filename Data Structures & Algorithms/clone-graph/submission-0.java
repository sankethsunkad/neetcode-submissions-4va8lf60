/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> hm;
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        hm = new HashMap<>();
        return buildTree(node);
    }

    Node buildTree(Node node) {
        if(hm.containsKey(node)) {
            return hm.get(node);
        }
        Node newNode = new Node(node.val);
        hm.put(node, newNode);
        for(Node neighbor : node.neighbors) {
            newNode.neighbors.add(buildTree(neighbor));
        }
        return newNode;
    }
}