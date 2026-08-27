class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] curr : board) {
            Arrays.fill(curr, '.');
        }

        helper(board, 0, n);
        return res;
    }

    void helper(char[][] board, int x, int n) {
        if(x == n){
            res++;
            return;
        }

        for(int i = 0;i < n;i++) {
            board[x][i] = 'Q';
            if(check(board, x, i, n)) {
                helper(board, x + 1, n);
            }
            board[x][i] = '.';
        }
    }
    public boolean check(char[][] board, int x, int y, int n) {
        for(int i = 0;i < x;i++) {
            if(board[i][y] == 'Q') return false;
        }

        for(int i = x - 1, j = y - 1;i >= 0 && j >= 0;i--, j--) {
            if(board[i][j] == 'Q') return false;
        }

        for(int i = x - 1, j = y + 1;i >=0 && j < n;i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}