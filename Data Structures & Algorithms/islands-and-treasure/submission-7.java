class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0;i < n;i++) {
            for(int j = 0;j < m;j++) {
                if(grid[i][j] == 0) {
                    helper(grid, i, j, 0);
                }
            }
        }

    }

    public void helper(int[][] grid, int n, int m, int val) {
        grid[n][m] = val;
        for(int[] dir : dirs) {
            int row = n + dir[0];
            int col = m + dir[1];
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] > val) {
                helper(grid, row, col, val + 1);
            }
        }
    }
}
