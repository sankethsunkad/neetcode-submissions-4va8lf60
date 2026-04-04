class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(board[i][j] == 'X') {
                    visited[i][j] = true;
                    continue;
                }
                if(i == 0 || j == 0 || i == (n - 1) || j == (m - 1)) {
                    if(!visited[i][j]) {
                        dfs(board, i, j, n, m, visited);
                    }
                }
            }
        }

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j, int n, int m, boolean[][] visited) {
        visited[i][j] = true;
        if((i + 1) < n && board[i + 1][j] == 'O' && visited[i + 1][j] != true) {
           dfs(board, i + 1, j, n, m, visited); 
        }
        if(j + 1 < m && board[i][j + 1] == 'O' && visited[i][j + 1] != true) {
           dfs(board, i, j + 1, n, m, visited); 
        }
        if((i - 1) >= 0 && board[i - 1][j] == 'O' && visited[i - 1][j] != true) {
           dfs(board, i - 1, j, n, m, visited); 
        }
        if(j - 1 >= 0 && board[i][j - 1] == 'O' && visited[i][j - 1] != true) {
           dfs(board, i, j - 1, n, m, visited); 
        }
    }
}
