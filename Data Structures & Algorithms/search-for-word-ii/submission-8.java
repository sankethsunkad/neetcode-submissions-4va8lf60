class Node {
    Node children[];
    boolean endOfWord;

    Node() {
        children = new Node[26];
        endOfWord = false;
    }

    public void addWord(Node root, String word) {
        Node curr = root;
        for(int i = 0;i < word.length();i++) {
            int num = word.charAt(i) - 'a';
            if(curr.children[num] == null) {
                Node node = new Node();
                curr.children[num] = node;
            }
            curr = curr.children[num];
        }
        curr.endOfWord = true;
    } 
}

class Solution {
    private Set<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        Node root = new Node();

        for(String word : words) {
            root.addWord(root, word);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                helper(root, i, j, board, visited, "");
            }
        }
        return new ArrayList<>(res);
    }


    public void helper(Node root, int i, int j, char[][] board, boolean[][] visited, String list) {
        int num = board[i][j] - 'a';
        Node next = root.children[num];
        if(next == null) return;
        list += board[i][j];
        visited[i][j] = true;
        if(next.endOfWord) {
            res.add(list);
        }
        int[][] dir = new int[][]{{1, 0} , {-1, 0}, {0, 1}, {0, -1}};
        for(int[] d : dir) {
            if((i + d[0]) >= 0 && (i + d[0]) < board.length && (j + d[1]) >= 0 && (j + d[1]) < board[0].length && !visited[i + d[0]][j + d[1]]) {
                helper(root.children[num], i + d[0], j + d[1], board, visited, list);
            }
        }
        visited[i][j] = false;
    }
}
