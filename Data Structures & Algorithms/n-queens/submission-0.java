class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                board[i][j] = '.';
            }
        }
        helper(board, 0);
        return res;
    }

    void helper(char[][] board, int r) {
        if(r == board.length) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c = 0;c < board.length;c++) {
            if(isValid(board, r, c)) {
                board[r][c] = 'Q';
                helper(board, r + 1);
                board[r][c] = '.';
            }
        }
        return;
    }

    boolean isValid(char[][] board, int r, int c) {
        int n = board.length;
        for(int i = r - 1;i >= 0;i--) {
            if(board[i][c] == 'Q') return false;
        }

        for(int i = r - 1, j = c - 1 ;i >= 0 && j >= 0;i--, j--) {
            if(board[i][j] == 'Q') return false;      
        }

        for(int i = r - 1, j = c + 1;i >= 0 && j < n;i--, j++) {
            if(board[i][j] == 'Q') return false;    
        }
        return true;
    }
}
