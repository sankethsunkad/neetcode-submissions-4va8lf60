class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        return dfs(grid, 0, 0, 0, visited, n, m);
    }

    public int dfs(int[][] grid, int r, int c, int t, boolean[][] visited, int n, int m) {
        if(r == n - 1 && c == m - 1) return Math.max(t, grid[n-1][m-1]);
        t = Math.max(t, grid[r][c]);
        visited[r][c] = true;
        int res = Integer.MAX_VALUE;
        if(r + 1 < n && !visited[r + 1][c]) {
            res = Math.min(res, dfs(grid, r + 1, c, t, visited, n, m));
        }
        if(r - 1 >= 0 && !visited[r-1][c]) {
            res = Math.min(res, dfs(grid, r - 1, c, t, visited, n , m));
        }
        if(c - 1 >=0 && !visited[r][c- 1]) {
            res = Math.min(res, dfs(grid, r, c- 1, t, visited, n, m));
        }
        if(c + 1 < m && !visited[r][c+ 1]) {
            res = Math.min(res, dfs(grid, r, c+1, t, visited, n, m));
        }
        visited[r][c] = false;
        return res;
    }
}
