class Solution {
    int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int n;
    int m;
    public int numIslands(char[][] grid) {
        this.n = grid.length;
        this.m = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    res++;
                    helper(grid, i, j, visited);
                }
            }
        }
        return res;
    }

    public void helper(char[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        for(int[] d : dir) {
            int nr = row + d[0];
            int nc = col + d[1];

            if(nr >=0 && nr < n && nc >=0 && nc < m && grid[nr][nc] == '1' && !visited[nr][nc]) {
                helper(grid, nr, nc, visited);
            }
        }
    }
}
