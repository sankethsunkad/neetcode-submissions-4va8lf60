class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int res = 0;
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    helper(i, j, n, m, grid, visited);
                    res++;
                }
            }
        }
        return res;
    }

    void helper(int i, int j, int n, int m, char[][] grid, boolean[][] visited) {
        if(i < 0 || i == n || j < 0 || j == m || visited[i][j] || grid[i][j] == '0') {
            return;
        }

        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        visited[i][j] = true;
        for(int[] d : dir) {
            helper(i + d[0], j + d[1], n, m, grid, visited);
        }
    }
}
