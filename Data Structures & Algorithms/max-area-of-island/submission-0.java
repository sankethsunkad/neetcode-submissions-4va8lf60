class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int maxArea = 0;

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(!visited[i][j]) {
                    if(grid[i][j] == 1) {
                        int area = dfs(i, j, grid, visited, n, m);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }
        return maxArea;
    }

    int dfs(int i, int j, int[][] grid, boolean[][] visited, int n, int m) {
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        int total = 0;
        total = total + dfs(i + 1, j, grid, visited, n, m); //bottom
        total = total + dfs(i, j + 1, grid, visited, n, m); //right
        total = total + dfs(i - 1, j, grid, visited, n, m); //left
        total = total + dfs(i, j - 1, grid, visited, n, m); //top
        return 1 + total;
    }
}
