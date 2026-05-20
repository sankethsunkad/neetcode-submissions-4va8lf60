class PrefixTree {
    class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;
    }
    
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(int i = 0;i < word.length();i++) {
            int num = word.charAt(i) - 'a';
            Node next;
            if(curr.children[word.charAt(i) - 'a'] == null) {
                next = new Node();
            }
            else {
                next = curr.children[word.charAt(i) - 'a'];
            }
            curr.children[word.charAt(i) - 'a'] = next;
            curr = next;
            if(i == word.length() - 1) {
                curr.endOfWord = true;
            }
        }
    }

    public boolean search(String word) {
        Node curr = root;
        for(int i = 0;i < word.length();i++) {
            if(curr.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.children[word.charAt(i) - 'a'];
            if(i == word.length() - 1 && curr.endOfWord != true) {
                return false;
            }
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0;i < prefix.length();i++) {
            if(curr.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}
