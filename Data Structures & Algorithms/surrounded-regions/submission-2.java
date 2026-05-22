class Solution {
    boolean[][] visited;
    int n, m;
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        visited = new boolean[n][m];

        for(int i = 0;i < n;i++) {
            if(board[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0, visited, board);
            }
            if(board[i][m - 1] == 'O' && !visited[i][m - 1]) {
                dfs(i, m - 1, visited, board);
            }
        }

        for(int i = 0;i < m;i++) {
            if(board[0][i] == 'O' && !visited[0][i]) {
                dfs(0, i, visited, board);
            }
            if(board[n - 1][i] == 'O' && !visited[n - 1][i]) {
                dfs(n - 1, i, visited, board);
            }
        }

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(int i, int j, boolean[][] visited, char[][] board) {
        visited[i][j] = true;

        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int[] d : dir) {
            int rc = i + d[0];
            int nc = j + d[1];
            if(rc < 0 || nc < 0 || rc >= n || nc >= m || visited[rc][nc] || board[rc][nc] == 'X') {
                continue;
            }
            dfs(rc, nc, visited, board);
        }
    }
}
