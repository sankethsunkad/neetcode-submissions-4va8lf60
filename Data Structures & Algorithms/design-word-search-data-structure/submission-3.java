class WordDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean endOfWord = false;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for(int i = 0;i < word.length();i++) {
            int num = word.charAt(i) - 'a';
            if(curr.children[num] == null) {
                curr.children[num] = new Node();
            }
            curr = curr.children[num];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }

    public boolean helper(String word, int index, Node curr) {
        if(index == word.length()) return curr.endOfWord;
        if(word.charAt(index) == '.') {
            for(int i = 0;i < 26;i++) {
                if(curr.children[i] != null) {
                    if(helper(word, index + 1, curr.children[i])) {
                        return true;
                    }
                }
            }
        }
        else {
            int num = word.charAt(index) - 'a';
            if(curr.children[num] == null) {
                return false;
            }
            curr = curr.children[num];
            return helper(word, index + 1, curr);
        }
        return false;
    }
}
