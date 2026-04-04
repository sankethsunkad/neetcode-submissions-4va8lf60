class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0;i < word.length();i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if(cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {  
        return helper(word, 0, root);
    }

    public boolean helper(String word, int index, TrieNode root) {
        if (index == word.length()) {
            return root.endOfWord;
        }

        char c = word.charAt(index);
        if(c == '.') {
            TrieNode[] children = root.children;
            for(int i = 0;i < 26;i++) {
                if(children[i] != null) {
                    if(helper(word, index + 1, children[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        else {
            int i = c - 'a';
            if(root.children[i] != null) {
                return helper(word, index + 1, root.children[i]);
            }
            return false;
        }
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}
