class Solution {
    int n;
    int m;
    String word;
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0) return true;
        this.n = board.length;
        this.m = board[0].length;
        this.word = word;
        boolean[][] check = new boolean[n][m];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(helper(board, check, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean helper(char[][] board, boolean[][] check, int i, int j, int index) {
        if(index == word.length() - 1 && board[i][j] == word.charAt(index)) return true;
        if(board[i][j] != word.charAt(index)) return false;

        check[i][j] = true;

        if((i + 1) < n && check[i + 1][j] != true) {
            if(helper(board, check, i + 1, j, index + 1)) return true;
        }

        if((j + 1) < m && check[i][j + 1] != true) {
            if(helper(board, check, i, j + 1, index + 1)) return true;
        }

        if((i - 1) >= 0 && check[i - 1][j] != true) {
            if(helper(board, check, i - 1, j, index + 1)) return true;
        }

        if((j - 1) >= 0 && check[i][j - 1] != true) {
            if(helper(board, check, i, j - 1, index + 1)) return true;
        }
        check[i][j] = false;
        return false;
    }
}
