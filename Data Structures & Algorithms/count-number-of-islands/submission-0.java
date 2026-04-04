class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islands = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(!visited[i][j]) {
                    if(grid[i][j] == '1') {
                        dfs(i, j, grid, visited, n, m);
                        islands++;
                    }
                }
            }
        }
        return islands;
    }

    void dfs(int i, int j, char[][] grid, boolean[][] visited, int n, int m) {
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || visited[i][j]) return;
        visited[i][j] = true;
        dfs(i + 1, j, grid, visited, n, m); //bottom
        dfs(i, j + 1, grid, visited, n, m); //right
        dfs(i - 1, j, grid, visited, n, m); //left
        dfs(i, j - 1, grid, visited, n, m); //top
    }
}
