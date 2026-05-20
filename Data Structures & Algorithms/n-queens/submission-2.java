class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                board[i][j] = '.';
            }
        }
        helper(0, board, n);
        return res;
    }

    void helper(int index, char[][] board, int n) {
        if(index == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }
        
        
        for(int i = 0;i < n;i++) {
            board[index][i] = 'Q';
            if(isValid(board, index, i)) {
                helper(index + 1, board, n);
            }
            board[index][i] = '.';
        }
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
