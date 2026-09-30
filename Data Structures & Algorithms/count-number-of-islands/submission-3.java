class Solution {
    int n;
    int m;
    int[][] visited;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m];

        int res = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(visited[i][j] == 0 && grid[i][j] == '1') {
                    res++;
                    helper(grid, i, j);
                }
            }
        }
        return res;
    }

    void helper(char[][] grid, int i, int j) {
        visited[i][j] = 1;

        for(int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if(x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == '1' && visited[x][y] == 0) {
                helper(grid, x, y);
            }
        }
    }
}
