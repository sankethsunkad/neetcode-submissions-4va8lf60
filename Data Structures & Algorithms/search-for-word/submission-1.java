class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if(helper(board, i, j, visited, word, 0)) return true;
            }
        }
        return false;
    }
    boolean helper(char[][] board, int i, int j, boolean[][] visited, String word, int index) {
        if(index == word.length()) return true;
        if(board[i][j] == word.charAt(index)) {
            if(index == word.length() - 1) return true;
            visited[i][j] = true;
            if((i + 1) < board.length && !visited[i + 1][j]) {
                if(helper(board, i + 1, j, visited, word, index + 1)) return true;
            }
            if((j + 1) < board[0].length && !visited[i][j + 1]) {
                if(helper(board, i, j + 1, visited, word, index + 1)) return true;
            }
            if((i - 1) >= 0 && !visited[i - 1][j]) {
                if(helper(board, i - 1, j, visited, word, index + 1)) return true;
            }
            if((j - 1) >= 0 && !visited[i][j - 1]) {
                if(helper(board, i, j - 1, visited, word, index + 1)) return true;
            }
            visited[i][j] = false;
        }
        return false;
    }
}
