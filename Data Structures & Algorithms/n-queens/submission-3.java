class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];

        for(char[] curr : board) {
            Arrays.fill(curr, '.'); 
        }

        helper(board, 0, n);
        return res;
    }

    public void helper(char[][] board, int i, int n) {
        if(i == n) {
            List<String> temp = new ArrayList<>();
            for(char[] curr : board) {
                String str1 = new String(curr);
                temp.add(str1);
            }
            res.add(temp);
            return;
        }
        
        for(int j = 0;j < n;j++) {
            board[i][j] = 'Q';
            if(check(board, i, j, n)) {
                helper(board, i + 1, n);
            }
            board[i][j] = '.';            
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
