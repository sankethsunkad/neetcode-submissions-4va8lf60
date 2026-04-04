class Solution {
    char[][] board;
    int n;
    int m;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.n = board.length;
        this.m = board[0].length;
        this.visited = new boolean[n][m];

        List<String> res = new ArrayList<>();
        for(String word : words) {
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    if(helper(word, 0, i, j)) {
                        res.add(word);
                        j = m;
                        i = n;
                    }
                }
            }
        }

        return res;
    }

    boolean helper(String word, int index, int i, int j) {
        if(index == word.length()) return true;

        if(board[i][j] != word.charAt(index)) {
            return false;
        }

        if(index == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;
        if(((i + 1) < n && !visited[i + 1][j] && helper(word, index + 1, i + 1, j)) || ((j + 1) < m) && !visited[i][j + 1] && helper(word, index + 1, i, j + 1)) {
            visited[i][j] = false;
            return true;
        }

        if(((i - 1) >= 0 && !visited[i - 1][j] && helper(word, index + 1, i - 1, j)) || ((j - 1) >= 0 && !visited[i][j - 1] && helper(word, index + 1, i, j - 1))) {
            visited[i][j] = false;
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
